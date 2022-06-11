package me.dio.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import me.dio.motivation.infra.MotivationConstants
import me.dio.motivation.R
import me.dio.motivation.infra.SecurityPreferences
import me.dio.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        securityPreferences = SecurityPreferences(this)

        //Acesso aos elementos de interface
        binding.buttonSave.setOnClickListener(this)


    }/**
     * Tratamento de clicks dos elementos
     */
    override fun onClick(view: View?) {
        val id: Int? = view?.id
        if (id == R.id.button_save) {
            handleSave()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * Salva o nome do usuário para utilizações futuras
     */
    private fun handleSave() {
        //Obtém o nome
        val name: String = binding.editName.text.toString()

        //Verifica se usuário preencheu o nome
        if (name == "") {
            Toast.makeText(this, getString(R.string.validation_mandatory_name) , Toast.LENGTH_LONG)
                .show()
        } else {
            //Salva os dados do usuário e redireciona para as frases
            securityPreferences.storeString(MotivationConstants.KEY.USER_NAME, name)

            //Impede que seja possível voltar a Activity
            finish()
        }
    }
}
