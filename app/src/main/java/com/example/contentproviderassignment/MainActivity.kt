package com.example.contentproviderassignment

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PERMISSION=100
    lateinit var list:ArrayList<Mess>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isPermissionGranted=ActivityCompat.
        checkSelfPermission(this,Manifest.permission.READ_SMS)==PackageManager.PERMISSION_GRANTED

        if(isPermissionGranted)
        {
            var fetch=ContentFetcher(this)
            list=fetch.fetchall()
            var adapter=MyAdapter(this,list)
            recycler.layoutManager=LinearLayoutManager(this)
            recycler.adapter=adapter
        }
        else
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_SMS),PERMISSION)
        }

    }
}
//val isPermissionGranted = ActivityCompat.checkSelfPermission(
//    this,
//    Manifest.permission.READ_CONTACTS
//) == PackageManager.PERMISSION_GRANTED
//
//if (!isPermissionGranted) {
//    ActivityCompat.requestPermissions(
//        this@MainActivity,
//        arrayOf(Manifest.permission.READ_CONTACTS),
//        CAMERA_PERMISSION_CODE
//    )
//} else {
//    listContacts = ContactFetcher(this).fetchAll()
//    var adapter=ContactsAdapter(this,listContacts!!)
//    recyclerView.layoutManager= LinearLayoutManager(this)
//    recyclerView.adapter=adapter
//}