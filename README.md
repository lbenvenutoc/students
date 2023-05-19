# Student management

_Project for student management_

## Start 🚀

_If you want check it, execute git clone https://github.com/lbenvenutoc/students.git._


### Pre-requirements 📋

_JDK 11, Maven 3.6.* and IDE for develop in Java (STS, Eclipse, etc)_


### Execution 🔧

_If toy have Maven, then execute:_

```
mvn spring-boot:run
```

## Runnin the tests ⚙️

_Open Postman_

### Test API GET [PC_NAME]:[PORT]/api/students

_List all students with active status_

```
Response:

[
    {
        "code": 1,
        "name": "Luis",
        "lastname": "Benvenuto",
        "state": 1,
        "age": 37
    },
    {
        "code": 5,
        "name": "Manuel",
        "lastname": "Donaire",
        "state": 1,
        "age": 37
    }
]

```

### Test API POST [PC_NAME]:[PORT]/api/students

_Insert a student in the database_

```
Request:

{
    "code":5,   
    "name":"Manuel",
    "lastname":"Donaire",
    "age":37,
    "state":1
}

Response:

{
    "code":5,   
    "name":"Manuel",
    "lastname":"Donaire",
    "age":37,
    "state":1
}
```

## Deployment 📦

_In this example I added a Dockerfile if you test the API in a Docker Container_

_First, execute:_

```
mvn clean package
```

_Second, execute the docker command for build a image from Dockerfile (Tag students:1):_

```
docker build -t students:1
```

_Finally, execute the docker command for run the container:_

```
docker run -p 8087:8085 students:1
```

## Authors ✒️

* **Luis Benvenuto** - [lbenvenutoc](https://github.com/lbenvenutoc)


