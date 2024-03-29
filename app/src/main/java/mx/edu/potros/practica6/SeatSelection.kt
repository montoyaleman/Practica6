package mx.edu.potros.practica6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie = -1
        val comfirmButton: Button = findViewById(R.id.comfirm)

        val bundle = intent.extras
        if(bundle != null){
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }

        comfirmButton.setOnClickListener{
            var intent: Intent = Intent(this,catalogo::class.java)
            startActivity(intent)
        }

        val comfirm: Button = findViewById(R.id.comfirm)
        comfirm.setOnClickListener{
            Toast.makeText(this, "Enjoy the movie! :D", Toast.LENGTH_LONG).show()
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener{ group, checkedId->
            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
            }
        }

        row2.setOnCheckedChangeListener{ group, checkedId->
            if (checkedId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }
        }

        row3.setOnCheckedChangeListener{ group, checkedId->
            if (checkedId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
            }
        }

        row4.setOnCheckedChangeListener{ group, checkedId->
            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedId)
            }
        }
    }
}