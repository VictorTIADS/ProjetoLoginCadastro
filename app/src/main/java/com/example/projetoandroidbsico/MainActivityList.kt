package com.example.projetoandroidbsico

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoandroidbsico.Adapter.Adapter
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main_list.*
import kotlinx.android.synthetic.main.listview.*
import org.jetbrains.anko.*

class MainActivityList : AppCompatActivity()
{
    var mListBooks = ArrayList<Books>()
    lateinit var mtitle:EditText
    lateinit var subtitle:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        val adapter = Adapter(this, mListBooks)

        var layoutManager = LinearLayoutManager(this)
        var recycleView = recycleView_Layout
        recycleView.layoutManager = layoutManager
        recycleView.adapter = adapter


        button_fab.setOnClickListener{

            //adapter.addItem(Books("Meu nome","Zé"))

            alert {
                title = "Inserir Livro"


                customView {

                    linearLayout {
                        this.orientation = LinearLayout.VERTICAL
                          mtitle = editText {
                            hint = "Título do Livro"

                        }.lparams(width = matchParent,height = wrapContent){
                            bottomMargin = dip(10)
                        }
                         subtitle = editText {
                            hint = "Subtítulo do Livro"

                        }.lparams(width = matchParent,height = wrapContent){
                            bottomMargin = dip(10)
                        }





                        padding = dip(16)
                    }

                }
                positiveButton("Inserir") { mListBooks.add(Books(mtitle.text.toString(),subtitle.text.toString()))
                adapter.addItem(mListBooks)}
            }.show()

        }








    }


}
