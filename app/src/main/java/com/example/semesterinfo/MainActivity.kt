package com.example.semesterinfo

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    val sub= arrayOf("CN","IS","AI","DMA","FCA","BCVS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom= findViewById<BottomNavigationView>(R.id.bottom)

        bottom.setOnItemSelectedListener {
            if(it.itemId==R.id.AC){
                replace(ac())
            }
            else    if(it.itemId==R.id.Rt){
                replace(Routine())
            }else{
                dialogue()
            }


                true
        }
    }

    private fun dialogue() {
         val builder= AlertDialog.Builder(this)
        builder.setTitle("Choose Your Subject")
        builder.setItems(sub, DialogInterface.OnClickListener{dialogInterface, i ->
            if(i==0){
             replace(cn())
            }else if(i==1){
                replace(BlankFragment())
            }else if(i==2){
                replace(ai())
            }else if(i==3){
                replace(dma())
            }else if(i==4){
                 replace(fca())
            }else{
                replace(bcvs())
            }
        })
        builder.show()
    }

    private fun replace(frag: Fragment) {
        val fragmentmanager= supportFragmentManager
        val fragmenttrn = fragmentmanager.beginTransaction()

        fragmenttrn.replace(R.id.frame,frag);
        fragmenttrn.commit()

    }
}