## 1. How to run it



#### Config Server

```bash
$ cd confsvr
$ mvn clean package docker:build
```

*****

#### Licensing Service

```bash
$ cd licensing-service
$ mvn clean package docker:build
```

*****

#### Run in all

```bash
$ docker-compose -f docker-spmia/docker-compose.yml up
```

##### 1. Check the DB

```bash
$ docker exec -it docker-spmia_database_1 bash # enter the db docker image
$ psql -U postgres -d eagle_eye_local # enter the database: eagle_eye_local
```
