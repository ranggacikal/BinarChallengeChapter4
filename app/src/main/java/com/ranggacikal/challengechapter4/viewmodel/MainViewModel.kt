package com.ranggacikal.challengechapter4.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var pilihanPlayer : String = ""
    var pilihanCom: String = ""
    var hasilValidasiPlayer: String = ""
    var numberCom: Int = 0

    fun validasiHasil(player: Int){
        when(player){
            1 -> pilihanPlayer = "batu"
            2 -> pilihanPlayer = "kertas"
            3 -> pilihanPlayer = "gunting"
        }

        Log.d("pilihanPlayer", "pilihanUser: $pilihanPlayer")

        val randomNumber = (1..3).random()

        numberCom = randomNumber

        when(randomNumber){
            1 -> pilihanCom = "batu"
            2 -> pilihanCom = "kertas"
            3 -> pilihanCom = "gunting"
        }

        Log.d("pilihanComputer", "pilihanCom: $pilihanCom")

        if (pilihanPlayer == pilihanCom){
            hasilValidasiPlayer = "draw"
        }else if (pilihanPlayer == "batu" && pilihanCom == "gunting"){
            hasilValidasiPlayer = "win"
        }else if (pilihanPlayer == "kertas" && pilihanCom == "batu"){
            hasilValidasiPlayer = "win"
        }else if (pilihanPlayer == "gunting" && pilihanCom == "kertas"){
            hasilValidasiPlayer = "win"
        }else if (pilihanPlayer == "gunting" && pilihanCom == "batu"){
            hasilValidasiPlayer = "lose"
        }else if (pilihanPlayer == "batu" && pilihanCom == "kertas"){
            hasilValidasiPlayer = "lose"
        }else if(pilihanPlayer == "kertas" && pilihanCom == "gunting"){
            hasilValidasiPlayer = "lose"
        }
    }

    fun setCom(): Int {
        return numberCom

    }

    fun hasilValidasi(): String {
        return hasilValidasiPlayer
    }

}