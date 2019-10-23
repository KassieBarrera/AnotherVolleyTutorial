package com.example.anothervolleytutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val LOG_TAG = "Main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        /*https://www.youtube.com/watch?v=EHpHRlJg1fk   --ForResult*/

        //stringRequest()

        //ObjectRequest()

        //jsonObjectRequestPost()
       // jsonArrayRequest()
        //jsonArrayRequestPost()

    }
        fun stringRequest() {
            val queue = Volley.newRequestQueue(this)
            val url = "https://kikopalomares.com"

            val stringRequest = StringRequest(url, Response.Listener { response ->
                Log.i(LOG_TAG, "Response is ${response.substring(1, 100)}")
            }, Response.ErrorListener { error ->
                error.printStackTrace()
            })
            queue.add(stringRequest)
        }

        fun ObjectRequest() {
            val queue = Volley.newRequestQueue(this)
            val url = "https://jsonplaceholder.typicode.com/posts/1"

            val jsonObjectRequest = JsonObjectRequest(url, null, Response.Listener { response ->
                Log.i(LOG_TAG, "Response is: $response")
            }, Response.ErrorListener { error ->
                error.printStackTrace()
                Log.e(LOG_TAG, "That didn't work!")
            })

            queue.add(jsonObjectRequest)

        }
        fun jsonObjectRequestPost() {
            Log.i(LOG_TAG, "jsonObjectRequestPost")

            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)

            val url = "https://jsonplaceholder.typicode.com/posts/1"

            val jsonObject = JSONObject()
            jsonObject.put("id", 1)
            jsonObject.put("title", "Hello K")

            // Request a JSONObject response from the provided URL.
            val jsonObjectRequest = JsonObjectRequest(url, jsonObject,
                Response.Listener { response ->
                    Log.i(LOG_TAG, "Response is: $response")
                },
                Response.ErrorListener { error ->
                    error.printStackTrace()
                    Log.e(LOG_TAG, "That didn't work!")
                }
            )

            // Add the request to the RequestQueue.
            queue.add(jsonObjectRequest)
        }

        fun jsonArrayRequest() {
            Log.i(LOG_TAG, "jsonArrayRequest")

            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)

            val url = "https://jsonplaceholder.typicode.com/posts"

            // Request a JSONArray response from the provided URL.
            val jsonArrayRequest = JsonArrayRequest(url,
                Response.Listener { response ->
                    Log.i(LOG_TAG, "Response is: $response")
                },
                Response.ErrorListener { error ->
                    error.printStackTrace()
                    Log.e(LOG_TAG, "That didn't work!")
                }
            )

            // Add the request to the RequestQueue.
            queue.add(jsonArrayRequest)
        }

        fun jsonArrayRequestPost() {
            Log.i(LOG_TAG, "jsonArrayRequestPost")

            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)

            val url = "https://jsonplaceholder.typicode.com/posts"

            val jsonArray = JSONArray()
            jsonArray.put(1)
            jsonArray.put(2)
            jsonArray.put(3)

            // Request a JSONArray response from the provided URL.
            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.POST, url, jsonArray,
                Response.Listener { response ->
                    Log.i(LOG_TAG, "Response is: $response")
                },
                Response.ErrorListener { error ->
                    error.printStackTrace()
                    Log.e(LOG_TAG, "That didn't work!")
                }
            )

            // Add the request to the RequestQueue.
            queue.add(jsonArrayRequest)
        }


}
