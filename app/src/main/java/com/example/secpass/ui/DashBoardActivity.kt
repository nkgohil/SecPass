package com.example.secpass.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.secpass.R
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_dash_board.*

class DashBoardActivity : AppCompatActivity(), View.OnClickListener,
    FloatingActionMenu.OnMenuToggleListener,NavigationView.OnNavigationItemSelectedListener {

    private var isopened= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        navigationDrawer()
        initView()
        navigationview.getMenu().getItem(1).setActionView(R.layout.menu_image)
    }
    private fun navigationDrawer() {
        //Naviagtion Drawer
        navigationview!!.bringToFront()
        navigationview!!.setNavigationItemSelectedListener(this)
// navigationView.setCheckedItem(R.id.nav_home);
        navbutton!!.setOnClickListener { if (drawerLayout!!.isDrawerVisible(GravityCompat.START)) drawerLayout!!.closeDrawer(
            GravityCompat.START) else drawerLayout!!.openDrawer(GravityCompat.START) }
    }
    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerVisible(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(GravityCompat.START)
        } else super.onBackPressed()
    }

    private fun initView() {
        userprofile.setOnClickListener(this)
        ids.setOnClickListener(this)
        cards.setOnClickListener(this)
        password.setOnClickListener(this)
        floatingmenu.setOnClickListener(this)
        personalinfo.setOnClickListener(this)
        floatingmenu.setOnMenuToggleListener(this)
        pan_card.setOnClickListener(this)
        election_card.setOnClickListener(this)
        driving_license.setOnClickListener(this)
        passport.setOnClickListener(this)
        wifi.setOnClickListener(this)
        ecommerce.setOnClickListener(this)
        address.setOnClickListener(this)
        name.setOnClickListener(this)
        phonenumber.setOnClickListener(this)
        socialmedia.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ids -> {
                pan_card.visibility = View.VISIBLE
                election_card.visibility = View.VISIBLE
                passport.visibility = View.VISIBLE
                driving_license.visibility = View.VISIBLE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                wifi.visibility=View.GONE
                ecommerce.visibility=View.GONE
                socialmedia.visibility=View.GONE
                address.visibility = View.GONE
                name.visibility = View.GONE
                phonenumber.visibility = View.GONE
            }

            R.id.password -> {
                wifi.visibility=View.VISIBLE
                ecommerce.visibility=View.VISIBLE
                socialmedia.visibility=View.VISIBLE
                pan_card.visibility = View.GONE
                election_card.visibility = View.GONE
                passport.visibility = View.GONE
                driving_license.visibility = View.GONE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                address.visibility = View.GONE
                name.visibility = View.GONE
                phonenumber.visibility = View.GONE
            }

            R.id.floatingmenu->{
                var a=0
                if(a%2!=0){
                    isopened=true
                    floatingmenu.close(isopened)
                    a+=1
                }
                else{
                    pan_card.visibility = View.GONE
                    election_card.visibility = View.GONE
                    passport.visibility = View.GONE
                    driving_license.visibility = View.GONE
                    address.visibility= View.GONE
                    name.visibility= View.GONE
                    phonenumber.visibility= View.GONE
                    wifi.visibility=View.GONE
                    ecommerce.visibility=View.GONE
                    socialmedia.visibility=View.GONE
                    a+=1
                }
            }

            R.id.personalinfo -> {
                address.visibility= View.VISIBLE
                name.visibility= View.VISIBLE
                phonenumber.visibility= View.VISIBLE
                ids.visibility = View.GONE
                personalinfo.visibility = View.GONE
                cards.visibility = View.GONE
                password.visibility = View.GONE
                pan_card.visibility = View.GONE
                election_card.visibility = View.GONE
                passport.visibility = View.GONE
                driving_license.visibility = View.GONE
                wifi.visibility=View.GONE
                ecommerce.visibility=View.GONE
                socialmedia.visibility=View.GONE
            }

            R.id.cards->{

            }

            R.id.pan_card->{
                startActivity(Intent(this,AddPanCardActivity::class.java))
            }

            R.id.election_card->{
                startActivity(Intent(this,AddElectionCardActivity::class.java))
            }

            R.id.passport->{
                startActivity(Intent(this,PassportActivity::class.java))
            }

            R.id.driving_license->{
                startActivity(Intent(this,DrivingLicenseActivity::class.java))
            }

            R.id.wifi->{
                startActivity(Intent(this, AddWifiActivity::class.java))
            }

            R.id.ecommerce->{
                startActivity(Intent(this, AddEcommerceSitesActivity::class.java))
            }

            R.id.address->{
                startActivity(Intent(this,AddAddressActivity::class.java))
            }

            R.id.phonenumber->{
                startActivity(Intent(this, AddPhoneNumberActivity::class.java))
            }

            R.id.socialmedia -> {
                startActivity(Intent(this,AddSocialMediaSites::class.java))
            }
            R.id.name->{
                startActivity(Intent(this,AddNameActivity::class.java))
            }
            R.id.userprofile->{
                startActivity(Intent(this,profile_screen::class.java))
            }
        }
    }

    override fun onMenuToggle(opened: Boolean) {
        if(floatingmenu.isOpened) {
            ids.visibility = View.VISIBLE
            personalinfo.visibility = View.VISIBLE
            cards.visibility = View.VISIBLE
            password.visibility = View.VISIBLE

        }
        else{
            wifi.visibility=View.GONE
            ecommerce.visibility=View.GONE
            socialmedia.visibility=View.GONE
            pan_card.visibility = View.GONE
            election_card.visibility = View.GONE
            passport.visibility = View.GONE
            driving_license.visibility = View.GONE
            address.visibility = View.GONE
            name.visibility = View.GONE
            phonenumber.visibility = View.GONE
            floatingmenu.close(true)
            floatingmenu.clearAnimation()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home_menu ->{
                startActivity(Intent(this,DashBoardActivity::class.java))
            }
            R.id.accsetting ->{
                startActivity(Intent(this,profile_screen::class.java))
            }
            R.id.settings ->{
                startActivity(Intent(this,SettingActivity::class.java))
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
        }
    }

