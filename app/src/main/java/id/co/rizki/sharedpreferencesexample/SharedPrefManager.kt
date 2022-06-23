package id.co.rizki.sharedpreferencesexample

import android.content.Context
import android.content.SharedPreferences


/**
 * Created by Rizky Putra on 23/06/22.
 */
object SharedPrefManager {

    private const val SHARED_PREF_FILENAME = "my_shared_pref"

    private const val KEY_ID_USER = "user_data_id"
    private const val KEY_NAMA_USER = "user_data_name"

    private fun getSharedPref(context: Context) : SharedPreferences {
        return context.getSharedPreferences(SHARED_PREF_FILENAME, 0)
    }

    fun saveUserName(context: Context, value: String) {
        val editor = getSharedPref(context).edit()
        editor.putString(KEY_NAMA_USER, value)
        editor.apply()
    }

    fun getUserName(context: Context) : String? {
        return getSharedPref(context).getString(KEY_NAMA_USER, "")
    }

    fun saveUserID(context: Context, value: Int) {
        val editor = getSharedPref(context).edit()
        editor.putInt(KEY_ID_USER, value)
        editor.apply()
    }

    fun getUserID(context: Context) : Int {
        return getSharedPref(context).getInt(KEY_ID_USER, 0)
    }




}