package com.vikydroid.demo.learning2.security

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
//import android.hardware.biometrics.BiometricPrompt
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.EncryptedSharedPreferences
import com.vikydroid.demo.R
import java.io.File
import javax.crypto.KeyGenerator

class BioMetricActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio_metric)
//        createPromptInfo()
        popUpBioMetricDialog()
//        createKey()
//        storingDataInSecretFile()
//        encryptedSharedPrefs()
    }

    private fun encryptedSharedPrefs() {
        EncryptedSharedPreferences.create(
            "my_secret_prefs",
            "keyAliasName",
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        ).edit {
            // Update secret values
        }
    }

    private fun storingDataInSecretFile() {
        val secretFile = File(filesDir, "super_secret")
        val encryptedFile = EncryptedFile.Builder(
            secretFile,
            applicationContext,
            "keyAliasName",
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB)
            .setKeysetAlias("file_key") // optional
            .setKeysetPrefName("secret_shared_prefs") // optional
            .build()

        encryptedFile.openFileOutput().use { outputStream ->
            // Write data to your encrypted file
        }

        encryptedFile.openFileInput().use { inputStream ->
            // Read data from your encrypted file
        }
    }

    private fun createKey() {
//        val masterKey = EncryptedFile
    }

    private fun popUpBioMetricDialog() {
        val biometricPrompt = BiometricPrompt(this, ContextCompat.getMainExecutor(this),
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    showToast("Success")
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    showToast("Error")
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    showToast("Failed")
                }
            })
        biometricPrompt.authenticate(createPromptInfo())
    }

    private fun showToast(s: String) {
        Toast.makeText(this@BioMetricActivity, s, Toast.LENGTH_SHORT).show()
    }

    private fun createPromptInfo(): BiometricPrompt.PromptInfo {
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Title")
            .setSubtitle("Sub Title")
            .setDescription("Description")
            // Authenticate without requiring the user to press a "confirm"
            // button after satisfying the biometric check
            .setConfirmationRequired(false)
            .setNegativeButtonText("Use Phone's Password")
            .build()
        return promptInfo
    }

    private fun geneareSecretkey(keyGenParameterSpec: KeyGenParameterSpec) {
        val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
        keyGenerator.init(keyGenParameterSpec)
        keyGenerator.generateKey()

    }
}