package com.liuguilin.kotlinweather.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.Toast
import com.liuguilin.kotlinweather.R
import com.liuguilin.kotlinweather.base.BaseActivity
import kotlinx.android.synthetic.main.activity_setting.*


/**
 * FileName: SettingActivity
 * Founder: LiuGuiLin
 * Create Date: 2019/12/24 10:55
 * Email: lgl@szokl.com.cn
 * Profile:
 */
class SettingActivity : BaseActivity(), View.OnClickListener {

    private val cm: ClipboardManager by lazy { getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun isShowBack(): Boolean {
        return true
    }

    override fun initView() {
        mReSelectCity.setOnClickListener(this)
        mQQGroup.setOnClickListener(this)

        mReSelectCity.text = getString(R.string.tv_re_select_city)
        mQQGroup.text = getString(R.string.tv_copy_qq)

        mAppVersion.text = "${getString(R.string.tv_version)}${getAppVersion()}"
    }

    private fun getAppVersion(): String {
        val pm = packageManager
        val info = pm.getPackageInfo(packageName, 0)
        return info.versionName
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mReSelectCity -> startActivity(Intent(this, CitySelectActivity::class.java))
            R.id.mQQGroup -> {
                val mClipData = ClipData.newPlainText("Label", getString(R.string.tv_qq_group))
                cm.setPrimaryClip(mClipData)
                Toast.makeText(this, getString(R.string.tv_cilp_ok), Toast.LENGTH_LONG).show()
            }
        }
    }
}