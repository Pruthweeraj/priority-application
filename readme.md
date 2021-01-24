# Priority Application

## DATABASE SCHEMA

table 1: priority
------------------
priority_id : autogenerated id (PK) (UK)

priority_value: varchar2(64)

table 2: user
--------------
user_id : auto generated (UK)

user_name : varchar2(128)

priority_id: foreign key

rating: integer

user_id_priority_id : ( composite Primary Key)(UK)

###### NOTE: Database Schema created based on KIS(Keep It Simple) Principle.

_**Rest Api**_

1) `Get All Priorities:
   `**GET** : `http:\localhost:8080/priority-app/priority`


2) `Save User with Rating:`
   **POST** : `http:\localhost:8080/priority-app/user`

`Payload:`

```
{
  "name": "Pruthweeraj Panda",
  "priorities": [
    {
      "name": "Connection",
      "rating": "4"
    },
    {
      "name": "Relationships",
      "rating": "5"
    },
    {
      "name": "Career",
      "rating": "5"
    },
    {
      "name": "Wealth",
      "rating": "4"
    }
  ]
}
```
