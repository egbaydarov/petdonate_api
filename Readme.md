**Get user Data**
----
  Returns json data about a single user.

* **URL**

  /apiv1/data/{token}

* **Method:**

  `GET`
  
*  **URL Params**

   **Required: token which recieved from google auth API**
 
   `token=String`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{}`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : ""}`

* **Sample Call:**

