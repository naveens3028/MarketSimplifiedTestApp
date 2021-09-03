package com.example.marketsimplifiedtestapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.bumptech.glide.Glide
import com.example.marketsimplifiedtestapp.R
import com.example.marketsimplifiedtestapp.database.AppDataBase
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private var id: Int? = null
    private lateinit var db: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        id = intent.getIntExtra("id", 0)
        db = AppDataBase.getInstance(this)!!

        setValuesToUI(db)
    }

    private fun setValuesToUI(db: AppDataBase) {

        val data = db.dataModelDao.findLastPage(id)

        Glide.with(this).load(data.owner?.avatarUrl).into(imgDataDetail)
        chapternameEdt.setText(data.comments)
        titleTxt.text = "FullName: " + data.fullName
        aboutTxt.text = "ID: " + data.id
        descriptionTxt.text = "Description: " + data.description
        bodyTxt.text = "Owner Type: " + data.owner!!.type
        urlTxt.text = "Url: " + data.htmlUrl

        chapternameEdt.doAfterTextChanged {
            data.id?.let { it1 -> db.dataModelDao.update(it.toString(), it1) }
        }

    }
}