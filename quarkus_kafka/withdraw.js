import http from 'k6/http';
import {check, sleep} from 'k6';

const expensePayload = JSON.parse(open("./withdraw.json"));

export default function () {
    const url = 'http://localhost:8080/transactions';

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
        vus: 10,
        duration: '60s'
    };

    const res = http.post(url, JSON.stringify(expensePayload), params);

    check(res, {'success creating expense': (r) => r.status === 201});
    sleep(1);
}
