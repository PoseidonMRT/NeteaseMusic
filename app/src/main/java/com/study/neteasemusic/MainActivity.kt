package com.study.neteasemusic

import android.os.Build
import kotlinx.android.synthetic.main.activity_main.*;
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.study.neteasemusic.base.activity.StatusBarCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : StatusBarCompatActivity(), NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{

    private var toggle: ActionBarDrawerToggle? = null

    override fun initView() {
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setBackgroundColor(resources.getColor(R.color.defaults_status_bar_color))
    }

    override fun initData() {
        toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle as ActionBarDrawerToggle)
        (toggle as ActionBarDrawerToggle).syncState()
        nav_view.setNavigationItemSelectedListener(this)
        main_toolbar_music.setOnClickListener(this)
        main_toolbar_disco.setOnClickListener(this)
        main_toolbar_friends.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            main_toolbar_disco -> {
                refreshViewState(0)
            }
            main_toolbar_friends -> {
                refreshViewState(1)
            }
            main_toolbar_music ->{
                refreshViewState(2)
            }

        }
    }

    fun refreshViewState(index: Int){
        when(index){
            0 -> {
                main_toolbar_disco.isSelected = true
                main_toolbar_friends.isSelected = false
                main_toolbar_music.isSelected = false
            }
            1 -> {
                main_toolbar_disco.isSelected = false
                main_toolbar_friends.isSelected = true
                main_toolbar_music.isSelected = false
            }
            2 -> {
                main_toolbar_disco.isSelected = false
                main_toolbar_friends.isSelected = false
                main_toolbar_music.isSelected = true
            }
        }
    }
    override fun initStatusBarColor(): Int {
        return ContextCompat.getColor(this, R.color.defaults_status_bar_color)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
