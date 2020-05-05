**Get User Data**
----
  Get data about a single user and his virtual pet state.

* **URL**

 `/apiv1/data/{token}`

* **Method:**

  `GET`
  
*  **URL Params**

   **Required: token which recieved from google auth API**
 
   `token=String`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 OK<br />
    **Content:**
     ```{
    "state": {
        "name": "ррр",
        "cur_HP": -2,
        "cur_Mana": -2,
        "cur_Stamina": -2,
        "type": "Собака",
        "skin": 2131165276,
        "id": "104383325999436478787"
    }
  
* **Error Response:**

  * **Code:** 500 INTERNAL_SERVER_ERROR <br />
    **Content:** `{}`

**Put User Data**
----
  Put data about a single user and his virtual pet state.

* **URL**

 `/apiv1/data/{token}`

* **Method:**

  `PUT`
  
*  **URL Params**

   **Required: token which recieved from google auth API**
 
   `token=String`

* **Data Params**

  Body:
  ```{
     "state": {
         "name": "ррр",
         "cur_HP": 58,
         "cur_Mana": -2,
         "cur_Stamina": 41,
         "type": "Собака",
         "skin": 2131165276,
         "id": "104383325999436478787"
     }
   }

* **Success Response:**

  * **Code:** 200 OK<br />
    **Content:**
    `Changes saved : String`
  
* **Error Response:**

  * **Code:** 500 INTERNAL_SERVER_ERROR <br />
    **Content:** `{...}`
    
**Post User Data**
----
  Post data about a single user and his virtual pet state (success only if user wasn't added before).

* **URL**

 `/apiv1/data/{token}`

* **Method:**

  `POST`
  
*  **URL Params**

   **Required: token which recieved from google auth API**
 
   `token=String`

* **Data Params**

  Body:
  ```{
     "state": {
         "name": "ррр",
         "cur_HP": 58,
         "cur_Mana": -2,
         "cur_Stamina": 41,
         "type": "Собака",
         "skin": 2131165276,
         "id": "104383325999436478787"
     }
   }

* **Success Response:**

  * **Code:** 200 OK<br />
    **Content:**
    `OK : String`
  
* **Error Response:**

  * **Code:** 500 INTERNAL_SERVER_ERROR <br />
    **Content:** `{...}`

