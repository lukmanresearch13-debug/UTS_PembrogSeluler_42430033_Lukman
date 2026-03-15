package com.example.uts_pembrogseluler_42430033_lukman

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val etJumlahMahasiswa = findViewById<EditText>(R.id.etJumlahMahasiswa)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvHasilLembar = findViewById<TextView>(R.id.tvHasilLembar)

        // Menerima data dari MainActivity
        val namaDosen = intent.getStringExtra("EXTRA_DOSEN")
        tvWelcome.text = "Selamat Mengajar,\nDosen $namaDosen"

        btnGenerate.setOnClickListener {
            val jumlahMhsInput = etJumlahMahasiswa.text.toString()

            if (jumlahMhsInput.isNotEmpty()) {
                val jumlahMhs = jumlahMhsInput.toInt()
                var hasilGenerate = ""

                // Modul 5: Percabangan If-Else
                if (jumlahMhs > 0) {
                    hasilGenerate += "Status: Kelas Berjalan\n"
                    hasilGenerate += "Total: $jumlahMhs Mahasiswa\n"
                    hasilGenerate += "-----------------------------------\n\n"
                } else {
                    hasilGenerate += "Status: Kelas Dibatalkan (0 Mahasiswa)\n\n"
                }

                // Modul 5: Perulangan For Loop
                for (i in 1..jumlahMhs) {
                    hasilGenerate += "Mahasiswa Ke-$i\n"
                    hasilGenerate += "Kehadiran : [ ] Hadir  [ ] Izin  [ ] Alpa\n"
                    hasilGenerate += "Nilai UTS : ...............\n\n"
                }

                tvHasilLembar.text = hasilGenerate
            } else {
                tvHasilLembar.text = "Harap isi jumlah mahasiswa terlebih dahulu."
            }
        }
    }
}