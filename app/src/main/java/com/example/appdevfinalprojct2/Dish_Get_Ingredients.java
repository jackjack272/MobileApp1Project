package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Dish_Get_Ingredients extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    RecyclerView.LayoutManager layoutManager;
//    private RequestQueue requestQueue;
//
//    private ArrayList<Dish> dishArrayList;
//    // api call components


    /// Pretains to the view

    private static String TAG = Dish_Get_Ingredients.class.getSimpleName();


    TextView yummy;
    private Button button;
    private EditText foodRestriction, foodCountryStyle, ing1, ing2, ing3, ing4;
    //ingredient




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_recipies);

        Log.v(TAG, "inside of recipes");
//        Log.v(TAG, "intent is "+parent.getSelectedItem());

        foodRestriction = findViewById(R.id.editTextTextPersonName3);
        foodCountryStyle = findViewById(R.id.editTextTextPersonName4);
        ing1 = findViewById(R.id.ingredient1);
        ing2 = findViewById(R.id.ingredient2);
        ing3 = findViewById(R.id.ingredient3);
        ing4 = findViewById(R.id.ingredient4);
        button= findViewById(R.id.chef_it_up);
        yummy= findViewById(R.id.textView11);

//        SharedPreferences preferences= getSharedPreferences("user_info", Context.MODE_PRIVATE);
//        String loose_weight="";
//        if(Boolean.valueOf(preferences.getBoolean("less_weight",true))){
//            loose_weight="loose weight";
//        }else{
//            loose_weight="gain weight";
//        }
//
//        yummy.setText("lets get you a yummy meal! with min of "+
//                String.valueOf(preferences.getFloat("weekly_cals",600))
//                        + " to help you "+loose_weight );




        autoSetTheValuesForDev(); //lil helper util :)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate that there are no empty
                if(foodRestriction.getText().toString().isEmpty()){
                    foodRestriction.setHint("Cant be Empty ");
                    return;
                }
                else if (foodCountryStyle.getText().toString().isEmpty()){
                    foodCountryStyle.setHint("Cant be Empty ");
                    return;

                }else if (ing1.getText().toString().isEmpty()){
                    ing1.setHint("Cant be Empty ");
                    return;

                }else if (ing2.getText().toString().isEmpty() ){
                    ing2.setHint("Cant be Empty ");
                    return;

                }else if (ing3.getText().toString().isEmpty() ){
                    ing3.setHint("Cant be Empty ");
                    return;

                }else if (ing4.getText().toString().isEmpty()){
                    ing4.setHint("Cant be Empty ");
                    return;
                }


                Bundle bundle = new Bundle();
                bundle.putString("restriction", foodRestriction.getText().toString());
                bundle.putString("culture", foodCountryStyle.getText().toString());
                bundle.putString("ing1", ing1.getText().toString());
                bundle.putString("ing2", ing2.getText().toString());
                bundle.putString("ing3", ing3.getText().toString());
                bundle.putString("ing4", ing4.getText().toString());


                Intent intent = new Intent(Dish_Get_Ingredients.this, Dish_RecipeeDisplay.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void autoSetTheValuesForDev(){
        foodRestriction.setText("vegetarian");
        foodCountryStyle.setText("Mexcian");
        ing1.setText("Cellery");
        ing2.setText("Noodles");
        ing3.setText("Butter");
        ing4.setText("noodles");
    }




}


    // api code moved to recipee display
//
//        // on click send to another page with intent and do api call and display on that page.
//        recyclerView = findViewById(R.id.recipee_destination);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        requestQueue = VollySingolton.getInstance(this).getRequestQueue();
//        dishArrayList = new ArrayList<>();
//        getRecipee();
//    }
//
//    private void getRecipee() {
////                String cusineStyle, String diet, int numDishes, int maxCalories,
////                             String ingrident1, String ingrident2,  String ingrident3  ){
//
//        String url = "https://api.spoonacular.com/recipes/complexSearch?apiKey=3e14d423c5b54657a99a4fa84e8d3905" +
//                "&cuisine=italian&diet=vegetarian&query=rice&maxCalories=2400&number=3&sourceUrl";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
////                        https://stackoverflow.com/questions/1568762/accessing-members-of-items-in-a-jsonarray-with-java
//                try {
//                    JSONArray response_array = response.getJSONArray("results");
//                    for (int i = 0; i < response_array.length(); i++) {
//
//                        JSONObject jsonObject = response_array.getJSONObject(i);
//
//                        JSONArray xx = jsonObject.getJSONObject("nutrition").getJSONArray("nutrients");
//                        JSONObject z;
//                        double calories = 0;
//                        for (int a = 0; a < xx.length(); a++) {
//                            z = xx.getJSONObject(i);
//                            Log.v(TAG, z.getString("amount"));
//                            calories = z.getDouble("amount");
//                        }
//
//                        Dish dish = new Dish(
//                                jsonObject.getInt("id"),
//                                jsonObject.getString("title"),
//                                jsonObject.getString("image"),
//                                calories
//                        );
////                                Log.v(TAG, String.valueOf("***************** DISH OBJ TO ARRAY ************************** "));
////                                Log.v(TAG, String.valueOf(dish));
//                        dishArrayList.add(dish);
//
//                    }
//                } catch (Exception e) {
//                }
//
//
//                // Reccle adapter comes here.
//                RecipeeAdapter recipeeAdapter = new RecipeeAdapter(dishArrayList, Get_Recipies.this);
//                recyclerView.setAdapter(recipeeAdapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });
//
//        Log.v(TAG, String.valueOf("************* DISH ARRAY ****************************** "));
//        Log.v(TAG, String.valueOf(dishArrayList));
//
//        requestQueue.add(request);
//    }


