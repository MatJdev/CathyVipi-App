package com.example.proyecto1

import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        showActivity()

        val button3 = findViewById<Button>(R.id.button3)

        button3.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }

        var btnAudio1 = findViewById<Button>(R.id.btnAudio1)
        var btnAudio2 = findViewById<Button>(R.id.btnAudio2)
        var btnAudio3 = findViewById<Button>(R.id.btnAudio3)
        var btnAudio4 = findViewById<Button>(R.id.btnAudio4)
        var btnAudio5 = findViewById<Button>(R.id.btnAudio5)
        var btnAudio6 = findViewById<Button>(R.id.btnAudio6)

        var mediaPlayer: MediaPlayer? = null
        var mediaPlayer1: MediaPlayer? = null

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        val soundPool1 = SoundPool.Builder().setAudioAttributes(audioAttributes)
            .setMaxStreams(10).build()

        val audioManager: AudioManager =
            getSystemService(Context.AUDIO_SERVICE)
                    as AudioManager

        val volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        val sound1 = soundPool1.load(this, R.raw.xocas_happy_hippo,1)
        val sound2 = soundPool1.load(this, R.raw.xokas_calla,1)
        val sound3 = soundPool1.load(this, R.raw.minipekka,1)
        val sound4 = soundPool1.load(this, R.raw.elxokas_ni_de_conia,1)

        var idStreamAudio1 = 0

        mediaPlayer = MediaPlayer.create(this,R.raw.elxokas_no_es_gracioso)
        mediaPlayer1 = MediaPlayer.create(this,R.raw.elxokas_quiero_que_estes_callado)


        btnAudio1.setOnClickListener {
            idStreamAudio1 = soundPool1.play(sound1,volume.toFloat(),volume.toFloat(),1,0,1f)
        }

        btnAudio2.setOnClickListener {
            //idStreamAudio1 = soundPool1.play(sound2,volume.toFloat(),volume.toFloat(),1,0,1f)
            soundPool1.play(sound2,10f,10f,1,0,1f)
        }

        btnAudio3.setOnClickListener {
            //idStreamAudio1 = soundPool1.play(sound2,volume.toFloat(),volume.toFloat(),1,0,1f)
            soundPool1.play(sound3,10f,10f,1,0,1f)
        }

        btnAudio4.setOnClickListener {
            //idStreamAudio1 = soundPool1.play(sound2,volume.toFloat(),volume.toFloat(),1,0,1f)
            soundPool1.play(sound4,10f,10f,1,0,1f)
        }

        btnAudio5.setOnClickListener {
            mediaPlayer?.start()
        }

        btnAudio6.setOnClickListener {
            mediaPlayer1?.start()
        }


    }

    fun showActivity(){
        Toast.makeText(this, "Activity de Audios", Toast.LENGTH_SHORT).show()
    }
}