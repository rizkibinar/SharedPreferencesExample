package id.co.rizki.sharedpreferencesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.rizki.sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showUserData()

        binding.btnSave.setOnClickListener {
            val idUser = binding.etIdUser.text.toString()
            val namaUser = binding.etNamaUser.text.toString()

//            save data shared preferences
//            val sharedPreferences = this.getSharedPreferences("my_shared_pref", 0)
//
//            val editor = sharedPreferences.edit()
//
//            editor.putInt(KEY_ID_USER, idUser.toInt())
//            editor.putString(KEY_NAMA_USER, namaUser)
//
//            editor.apply()

            SharedPrefManager.saveUserID(this,idUser.toInt())
            SharedPrefManager.saveUserName(this,namaUser)

            showUserData()
        }
    }

    private fun showUserData() {
//        get data shared preferences
//        val sharedPreferences = this.getSharedPreferences("my_shared_pref", 0)
//
//        val idUser = sharedPreferences.getInt(KEY_ID_USER, -1)
//        val namaUser = sharedPreferences.getString(KEY_NAMA_USER, "")

        val idUser = SharedPrefManager.getUserID(this)
        val namaUser = SharedPrefManager.getUserName(this)

        binding.tvSavedId.text = "Id Tersimpan : $idUser"
        binding.tvSavedNama.text = "Nama Tersimpan : $namaUser"

    }

    companion object {
        const val KEY_ID_USER = "user_data_id"
        const val KEY_NAMA_USER = "user_data_name"
    }

}