package com.vikydroid.demo.learning.vpn

import android.net.Credentials
import android.net.VpnService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vikydroid.demo.R
import java.security.KeyStore

class VPNActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_v_p_n)
        var v = VpnService()
//        var d = KeyStore.getInstance().saw(Credentials.VPN)
    }
}