package com.zhixin.wedeep.legotest.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.zhixin.wedeep.legotest.R
import com.zhixin.wedeep.legotest.databinding.ActivityLegotestBinding
import com.zhixin.wedeep.legotest.legotheme.data.LegoTheme

@Route(path = "/legotest/test/LegoTest")
class LegoTestActivity: AppCompatActivity() {
    @Autowired(name="key4")
    lateinit var legoTheme:LegoTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        val binding: ActivityLegotestBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_legotest)
        binding.legoTheme = this.legoTheme
    }
}