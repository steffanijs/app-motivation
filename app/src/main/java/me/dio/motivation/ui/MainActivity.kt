package me.dio.motivation.ui


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import me.dio.motivation.R
import me.dio.motivation.data.Mock
import me.dio.motivation.databinding.ActivityMainBinding
import me.dio.motivation.infra.MotivationConstants
import me.dio.motivation.infra.SecurityPreferences
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var securityPreferences: SecurityPreferences

    private var categoryId = 1
    private var filter: Int = MotivationConstants.FILTER.ALL
    private val mock: Mock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Adiciona eventos
        setListeners()

        securityPreferences = SecurityPreferences(this)

        // Remove a supportActionBar
        supportActionBar?.hide()

        //Inicializa
        handleFilter(R.id.image_all)
        refreshPhrase()
        showUserName()
    }

        override fun onStart() {
        super.onStart()
    }

        override fun onResume() {
        super.onResume()
            showUserName()

    }

        override fun onPause() {
        super.onPause()
    }

        override fun onStop() {
        super.onStop()
    }

    //Atribui Eventos aos elementos
    private fun setListeners() {
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.textUserName.setOnClickListener(this)
    }

    /**
     * Trata eventos de click
     */
    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            refreshPhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)) {
            handleFilter(view.id)
        } else if (view.id == R.id.text_user_name) {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun refreshPhrase() {
        binding.textPhrase.text = mock.getPhrase(filter, Locale.getDefault().language)
    }

    private fun showUserName() {
        val name = securityPreferences.getStoredString(MotivationConstants.KEY.USER_NAME)
        val hello = getString(R.string.hello)
        binding.textUserName.text = "$hello, $name!"
    }

    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

}



