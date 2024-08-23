package com.eudes.hardwareexplorer

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.eudes.hardwareexplorer.databinding.ActivityMainBinding
import com.eudes.hardwareexplorer.databinding.ActivityMenuBinding
import com.eudes.hardwareexplorer.fragments.AnotarFragment
import com.eudes.hardwareexplorer.fragments.ExibirAnotacaoFragment
import com.eudes.hardwareexplorer.fragments.PrincipalFragment

class MenuActivity : AppCompatActivity() {
    private val binding by lazy{ActivityMenuBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                    R.id.anotacoes -> exibirFragment(AnotarFragment())
                    R.id.exibir -> exibirFragment(ExibirAnotacaoFragment())
                    R.id.home ->exibirFragment(PrincipalFragment())
                else ->{}
            }
            true
        }
    }
    private fun exibirFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}