package com.ranggacikal.challengechapter4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ranggacikal.challengechapter4.databinding.ActivityMainBinding
import com.ranggacikal.challengechapter4.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // di sni kamu bisa gunakan binding.run {} dan di dalam run nya kamu bisa memanggil id langsung biar kamu tidak memanggil secara berulang untuk binding nya
        binding.imgRefresh.setOnClickListener {
            binding.tvVs.visibility = View.VISIBLE
            binding.tvPemainMenang.visibility = View.GONE
            binding.tvComMenang.visibility = View.GONE
            binding.tvDraw.visibility = View.GONE
            binding.imgBatuPlayer.setBackgroundColor(Color.WHITE)
            binding.imgBatuCom.setBackgroundColor(Color.WHITE)
            binding.imgKertasCom.setBackgroundColor(Color.WHITE)
            binding.imgGuntingCom.setBackgroundColor(Color.WHITE)
        }

        binding.imgBatuPlayer.setOnClickListener {
            binding.imgBatuCom.setBackgroundColor(Color.WHITE)
            binding.imgGuntingCom.setBackgroundColor(Color.WHITE)
            binding.imgKertasCom.setBackgroundColor(Color.WHITE)
            binding.imgBatuPlayer.setBackgroundColor(Color.GREEN)
            viewModel.validasiHasil(1)
            when(viewModel.setCom()){
                1 -> binding.imgBatuCom.setBackgroundColor(Color.GREEN)
                2 -> binding.imgKertasCom.setBackgroundColor(Color.GREEN)
                else -> binding.imgGuntingCom.setBackgroundColor(Color.GREEN)
            }
            if (viewModel.hasilValidasi() == "win"){
                binding.tvVs.visibility = View.GONE
                binding.tvPemainMenang.visibility = View.VISIBLE
                binding.tvComMenang.visibility = View.GONE
                binding.tvDraw.visibility = View.GONE
            }else if (viewModel.hasilValidasi() == "lose"){
                binding.tvVs.visibility = View.GONE
                binding.tvPemainMenang.visibility = View.GONE
                binding.tvComMenang.visibility = View.VISIBLE
                binding.tvDraw.visibility = View.GONE
            }else{
                binding.tvVs.visibility = View.GONE
                binding.tvPemainMenang.visibility = View.GONE
                binding.tvComMenang.visibility = View.GONE
                binding.tvDraw.visibility = View.VISIBLE
            }
        }
    }
}
