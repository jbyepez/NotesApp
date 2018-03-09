# NotesApp
________________________________________________________________________

LIST OF METHODS

Get all users:
Method: GET
Mapping: ```"host/users"```

Insert an user:
Method: POST
Mapping: ```"/users/insert"```

Get user by username:
Method: GET
Mapping: ```"/users/username/{username}"```

Get notes of an user by username:
Method: Get
Mapping: ```"/users/username/{username}/notes"```

Insert a note for a user by username:
Method: POST
Mapping: ```"/users/username/{username}/notes/insert"```
The user inside the Json, if any, will be replaced by the stored with the username, or by NULL

Delete an user by username:
Method: DELETE
Mapping: ```"/users/username/{username}/delete"```

Get user by id:
Method: GET
Mapping: ```"/users/id/{id}"```

Get notes of an user by id:
Method: Get
Mapping: ```"/users/id/{id}/notes"```

Insert a note for a user by id:
Method: POST
Mapping: ```"/users/id/{id}/notes/insert"```
The user inside the Json, if any, will be replaced by the stored with the username, or by NULL

Delete an user by id:
Method: DELETE
Mapping: ```"/users/id/{id}/delete"```

Get all notes:
Method: GET
Mapping: ```"/notes"```

Insert a note:
Method: POST
Mapping: ```"/notes/insert"```

Delete a note:
Method: DELETE
Mapping: ```"/notes/{id}/delete"```

Get a note:
Method: GET
Mapping: ```"/notes/{id}"```

_________________________________________________________________

Example of user:
```
{
    "id": "5aa1f15ddff6fd4730001294",
    "username": "mari",
    "name": "Mariana"
}
```

Example of a note:
```
{
    "id": "5aa1f15ddff6fd4730001296",
    "text": "Hacer la tarea",
    "date": "2018-03-07T12:30:00.000+0000",
    "user": {
        "id": "5aa1f15ddff6fd4730001294",
        "username": "mari",
        "name": "Mariana"
    }
}
```
