# Quarkus with kafka


### start service

```zsh

   docker-compose down && docker-compose up -d --build
   
   //make sure have k6
   // brew install k6

```

### Run with k6

```zsh
    k6 run ./deposit.js
    k6 run ./withdraw.js
```




ref:<a href="https://github.com/wesleyfuchter/cqrs-quarkus-kafka" alt="quarkus-kafka">click me!</a>
