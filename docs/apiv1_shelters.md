**Get Shelter Image**
----
  Get shelter image.

* **URL**

 `apiv1/shelter/{id}/image/{token}`

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:** 
   
   `token` (Now uncheked, able to be any non-empty string)
   
   `id` (Shelter Identifier)

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 OK<br />
    **Content:** `image`
* **Error Response:**

  * **Code:** 500 INTERNAL_SERVER_ERROR <br />
    **Content:** `{}`
    
**Get Shelters**
----
  Get list of animals id's in specified shelter.

* **URL**

 `apiv1/shelters/{token}`

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:** 
   
   `token` (Now uncheked, able to be any non-empty string)

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 OK<br />
    **Content:**
    ```json
    [
      {
          "id": 22,
          "name": "Каждая Собака",
          "location": "ул. Зорге",
          "url": "http://priut-zorge.ru/",
          "email": "priyutzorge@mail.ru",
          "phone_number": "+79167942297",
          "account": "1234 5678 9101 1123"
      },
      {
          "id": 2,
          "name": "Красная Сосна",
          "location": "NaN",
          "url": "priut-ks.ru",
          "email": "redpine@bk.ru",
          "phone_number": "7(909)943-85-48",
          "account": "NaN"
      },
      {
          "id": 34,
          "name": "Каждая Собака1",
          "location": "ул. Зорге",
          "url": "http://priut-zorge.ru/",
          "email": "priyutzorge@mail.ru",
          "phone_number": "+79167942297",
          "account": "1234 5678 9101 1123"
      },
      {
          "id": 36,
          "name": "Каждая Собака2",
          "location": "ул. Зорге",
          "url": "http://priut-zorge.ru/",
          "email": "priyutzorge@mail.ru",
          "phone_number": "+79167942297",
          "account": "1234 5678 9101 1123"
      }
    ]
    ```
* **Error Response:**

  * **Code:** 500 INTERNAL_SERVER_ERROR <br />
    **Content:** `{}`    
