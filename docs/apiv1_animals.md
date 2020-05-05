**Get Animal Image**
----
  Get animal image.

* **URL**

 `apiv1/animal/{id}/image/{token}`

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:** 
   
   `token` (Now uncheked, able to be any non-empty string)
   
   `id` (Animal Identifier)

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 OK<br />
    **Content:** `image`
* **Error Response:**

  * **Code:** 500 INTERNAL_SERVER_ERROR <br />
    **Content:** `{}`
    
**Get Animals**
----
  Get list of animals id's in specified shelter.

* **URL**

 `/apiv1/animals/{shelterId}`

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:** 
   
   `shelter_id` (Shelter Identifier)

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 OK<br />
    **Content:**
    ```json
    [
      {
          "id": 1,
          "shelter_id": 2,
          "type": "Кошка",
          "name": "Мурка",
          "appear": "Рыжий с белым окрас",
          "behavior": "Любит играть с детьми",
          "gender": "Девочка"
      },
      {
          "id": 2,
          "shelter_id": 2,
          "type": "Собака",
          "name": "Бобик",
          "appear": "Среднего размера, 60 — 80 см в холке",
          "behavior": "Хороший охранник",
          "gender": "Мальчик"
      }
    ]
    ```
* **Error Response:**

  * **Code:** 500 INTERNAL_SERVER_ERROR <br />
    **Content:** `{}`    
