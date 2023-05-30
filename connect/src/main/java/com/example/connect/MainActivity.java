package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    CosmosClient client = new CosmosClientBuilder()
//            .endpoint("https://your-cosmosdb-account.documents.azure.com:443/")
//            .key("your-cosmosdb-account-key")
//            .build();
//    CosmosDatabase database = client.getDatabase("your-database-id");
//    CosmosContainer container = database.getContainer("your-container-id");
}