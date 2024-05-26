# Historical Landmarks API

## Introduction
The Historical Landmarks API provides a platform for users to interact with data related to historical landmarks and figures. It supports operations to view, add, update, and delete landmarks, and to view historical figures associated with these landmarks. Landmarks can be grouped by their country of location, and details about their history, preservation efforts, and associated historical figures can be accessed.

## Base URL
The base URL for the API is `http://localhost:8082`.

## API Endpoints

### 1. Add a New Country

- **HTTP Method:** `POST`
- **Endpoint:** `/countries`
- **Description:** Add a new country associated with historical landmarks.
- **Headers:** `Content-Type: application/json`
- **Request Body:**
    ```json
    {
        "name": "Spain",
        "capital": "Madrid"
    }
    ```
- **Responses:**
    - **200 Created:** The country was successfully created.
        ```json
        {
            "name": "Spain",
            "capital": "Madrid",
            "landmarks": [],
            "id": 2
        }
        ```
    - **400 Bad Request:** The request was invalid.

---

### 2. Get All Countries

- **HTTP Method:** `GET`
- **Endpoint:** `/countries`
- **Description:** Retrieve all current countries.
- **Headers:** `Accept: application/json`
- **Responses:**
    - **200 OK:** The request was successful.
        ```json
        [
            {
                "name": "Italy",
                "capital": "Rome",
                "landmarks": [],
                "id": 1
            },
            {
                "name": "Spain",
                "capital": "Madrid",
                "landmarks": [],
                "id": 2
            }
        ]
        ```
    - **204 No Content:** No countries were found.

---

### 3. Get a Single Country

- **HTTP Method:** `GET`
- **Endpoint:** `/countries/{id}`
- **Description:** Retrieve a single country by its ID.
- **Headers:** `Accept: application/json`
- **Path Parameters:** `id` (integer): ID of the country
- **Responses:**
    - **200 OK:** The request was successful.
        ```json
        {
            "name": "Spain",
            "capital": "Madrid",
            "landmarks": [],
            "id": 2
        }
        ```
    - **404 Not Found:** The country was not found.

---

### 4. Update a Country

- **HTTP Method:** `PUT`
- **Endpoint:** `/countries/{id}`
- **Description:** Update a country's details.
- **Headers:** `Content-Type: application/json`
- **Path Parameters:** `id` (integer): ID of the country
- **Request Body:**
    ```json
    {
        "name": "Ireland",
        "capital": "Madrid"
    }
    ```
- **Responses:**
    - **200 OK:** The country was successfully updated.
        ```json
        {
            "name": "Spain",
            "capital": "Madrid",
            "landmarks": [],
            "id": 2
        }
        ```
    - **400 Bad Request:** The request was invalid.
    - **404 Not Found:** The country was not found.

---

### 5. Delete a Country

- **HTTP Method:** `DELETE`
- **Endpoint:** `/countries/{id}`
- **Description:** Delete a country.
- **Headers:** `Accept: application/json`
- **Path Parameters:** `id` (integer): ID of the country
- **Responses:**
    - **204 No Content:** The country was successfully deleted.
    - **404 Not Found:** The country was not found.

---
### 6. Add a New Landmark to a Country
- **HTTP Method:** `POST`
- **Endpoint:** `/countries/{countryid}/add-historical-landmark/{historical landmark id}`
- **Description:** Add a historical landmark to a country.
- **Headers:** `Content-Type: application/json`

## API Endpoints for Historical Landmarks

### 1. Add a New Landmark

- **HTTP Method:** `POST`
- **Endpoint:** `/historical-landmarks`
- **Description:** Add a new historical landmark.
- **Headers:** `Content-Type: application/json`
- **Request Body:**
    ```json
    {
    "name": "La Sagrada Familia",
    "history": "The origins of Sagrada Familia are around 1866 when a congregation of devotees of St. Joseph had the idea of building a temple in his honor.",
    "visitor_guides": "Visitors should book tickets in advance, dress respectfully, and consider joining guided tours for deeper insights. Nearby attractions include Park Güell and Casa Batlló..",
    "pres_eff":"Sagrada Familia's preservation efforts focus on maintaining its structural integrity, conducting restoration projects, researching materials, and educating visitors."
}
    ```
- **Responses:**
    - **200 Created:**
    - **400 Bad Request:**

---

### 2. Get All Landmarks

- **HTTP Method:** `GET`
- **Endpoint:** `/historical-landmarks`
- **Description:** Retrieve all current landmarks.
- **Headers:** `Accept: application/json`
- **Responses:**
    - **200 OK:**
    - **204 No Content:**

---

### 3. Get a Single Landmark

- **HTTP Method:** `GET`
- **Endpoint:** `/historical-landmarks/{id}`
- **Description:** Retrieve a single landmark by its ID.
- **Headers:** `Accept: application/json`
- **Path Parameters:** `id` (integer): ID of the landmark
- **Responses:**
    - **200 OK:**
    - **404 Not Found:**

---

### 4. Update a Landmark

- **HTTP Method:** `PUT`
- **Endpoint:** `/historical-landmarks/{id}`
- **Description:** Update a landmark's details.
- **Headers:** `Content-Type: application/json`
- **Path Parameters:** `id` (integer): ID of the landmark
- **Responses:**
    - **200 OK:**
    - **400 Bad Request:**
    - **404 Not Found:**

---

### 5. Delete a Landmark

- **HTTP Method:** `DELETE`
- **Endpoint:** `/historical-landmarks/{id}`
- **Description:** Delete a landmark.
- **Headers:** `Accept: application/json`
- **Path Parameters:** `id` (integer): ID of the landmark
- **Responses:**
    - **204 No Content:**
    - **404 Not Found:**

### 6. Add a New historical figure to a Landmark
- **HTTP Method:** `POST`
- **Endpoint:** `/historical-landmarks/{landmarkid}/add-historical-figure/{historical figure id}`
- **Description:** Add a historical figure to a landmark.
- **Headers:** `Content-Type: application/json`

## API Endpoints for Historical Figures

### 1. Add a New Historical Figure

- **HTTP Method:** `POST`
- **Endpoint:** `/historical-figures`
- **Description:** Add a new historical figure.
- **Headers:** `Content-Type: application/json`
- **Request Body:**
    ```json
    {
    "name":"Antoni Gaudí",
    "biography":"Born in 1852, was a Catalan architect famed for his designs blending nature and religion. His works include the Sagrada Familia, Park Güell, and Casa Batlló. Gaudí's innovative style, defines Barcelona's architectural landscape. He passed away in 1926."
    }
    ```
- **Responses:**
    - **200 Created:**
    - **400 Bad Request:**

---

### 2. Get All Historical Figures

- **HTTP Method:** `GET`
- **Endpoint:** `/historical-figures`
- **Description:** Retrieve all current historical figures.
- **Headers:** `Accept: application/json`
- **Responses:**
    - **200 OK:**
    - **204 No Content:**

---

### 3. Get a Single Historical Figure

- **HTTP Method:** `GET`
- **Endpoint:** `/historical-figures/{id}`
- **Description:** Retrieve a single historical figure by its ID.
- **Headers:** `Accept: application/json`
- **Path Parameters:** `id` (integer): ID of the historical figure
- **Responses:**
    - **200 OK:**
    - **404 Not Found:**

---

### 4. Update a Historical Figure

- **HTTP Method:** `PUT`
- **Endpoint:** `/historical-figures/{id}`
- **Description:** Update a historical figure's details.
- **Headers:** `Content-Type: application/json`
- **Path Parameters:** `id` (integer): ID of the historical figure
- **Responses:**
    - **200 OK:**
    - **400 Bad Request:**
    - **404 Not Found:**

---

### 5. Delete a Historical Figure

- **HTTP Method:** `DELETE`
- **Endpoint:** `/historical-figures/{id}`
- **Description:** Delete a historical figure.
- **Headers:** `Accept: application/json`
- **Path Parameters:** `id` (integer): ID of the historical figure
- **Responses:**
    - **204 No Content:** 
    - **404 Not Found:** 

---
