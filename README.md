# MongoDB Spring Boot Demo App

# Characteristics

* NoSQL database
* JSON documents (BSON)
* Flexible structure to store the data
* Large amount of data can be easily managed

## MongoDB Terms

SQL         | MongoDB
 :---:      | :---: |
Database    | Database |
Table       | Collection
Column      | Field
Row         | Document
Foreign Key | Sub Document (Reference)

## CRUD Operations

* Read document

```
{ "name" : "Tiago" }
```

* AND query

```
{ $and : [ { "name" : "test" }, { "mail" : "test@gmail.com" } ] }
```

* OR query

```
{ $or : [ { "name" : "Tiago" }, { "mail" : "tiago@gmail.com" } ] }
```

* IN query

```
{ "name" : { $in : [ "Tiago", "Test" ] } }
```

* Update document

One document -> update() or updateOne()

Many documents -> updateMany()

```
db.student.update(
    {
        "name": "Tiago"
    },
    {
        $set: {
            "mail": "tiago@gmail.com"
        }
    }
)
```

* Delete document

```
db.student.remove(
    {
        "name": "Tiago"
    }
)
```

* Find query

```
db.student.find(
    {
        "name": "Tiago"
    }
)
```

## Pagination

Formula: (Page No -1) * Page Size

Page No | Skip | Limit (Page Size)
 :---:  | :---:| :---: |
1       | 0    | 10
2       | 10   | 10 
3       | 20   | 10
