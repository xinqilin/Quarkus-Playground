import http from 'k6/http';
import {check, sleep} from 'k6';

const incomePayload = JSON.parse(open("./deposit.json"));

export default function () {
    const url = 'http://localhost:8080/transactions';

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
        vus: 10,
        duration: '60s'
    };

    const res = http.post(url, JSON.stringify(incomePayload), params);

    check(res, {
        'success creating income': (r) => r.status === 201
    });
    sleep(1);
}
