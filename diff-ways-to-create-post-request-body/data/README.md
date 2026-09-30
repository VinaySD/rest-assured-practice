# Students JSON Server

## 🚀 How to Run

### 1. Open Terminal

Open **CMD** or **PowerShell** and navigate to the folder containing `students.json`.

```bash
cd path/to/your/folder
```

### 2. Start JSON Server

Run:

```bash
json-server students.json
```

> Make sure `students.json` is present in the current folder.

## 🌐 Server Details

After starting the server, JSON Server will provide the following:

**Index:**

```text
http://localhost:3000/
```

**Students Endpoint:**

```text
http://localhost:3000/students
```

**Static Files:**

```text
Serving ./public directory if it exists
```

## 📌 API Endpoint

You can access the students data using:

```text
GET http://localhost:3000/students
```

You can open the endpoint directly in your browser or use tools such as **Postman** to test the API.

## 🛑 Stop the Server

To stop JSON Server, press:

```text
Ctrl + C
```


## 💡 Note

Run the `json-server students.json` command **from the directory containing `students.json`**.
