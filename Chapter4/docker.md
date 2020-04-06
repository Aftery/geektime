~~~jshelllanguage
### mongo
docker pull daocloud.io/library/mongo
docker run --name mongo -p 27017:27017 -v ~/docker-data/mongo:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d daocloud.io/library/mongo
### 进入到mongo容器中
docker exec -it mongo bash
### 登陆mongo数据库
mongo -u admin -p admin
### 创建库
use springbucks;
### 
db.createUser( {
user: "springbucks", pwd: "springbucks", roles: [
{ role: "readWrite", db: "springbucks" } ]
} );
~~~
~~~jshelllanguage
### redis
docker pull docker
###启动redis
docker run --name redis -d -p 6379:6379 redis
~~~

