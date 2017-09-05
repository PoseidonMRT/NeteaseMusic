package com.study.neteasemusic

import kotlinx.android.synthetic.main.activity_main.*;
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.study.neteasemusic.base.activity.StatusBarCompatActivity
import com.study.neteasemusic.base.adapter.BaseFragmentPagerAdapter
import com.study.neteasemusic.mainpage.fragment.MainDiscoFragment
import com.study.neteasemusic.mainpage.fragment.MainFriendsFragment
import com.study.neteasemusic.mainpage.fragment.MainMusicFragment
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : StatusBarCompatActivity(), NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener ,ViewPager.OnPageChangeListener{

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var mFragments: List<Fragment>
    private lateinit var mFragmentPagerAdapter: BaseFragmentPagerAdapter
    private lateinit var discoFragment: MainDiscoFragment
    private lateinit var musicFragment: MainMusicFragment
    private lateinit var friendsFragment: MainFriendsFragment
    private val MUSIC_INDEX = 0
    private val DISCO_INDEX = 1
    private val FRIENDS_INDEX = 2

    override fun initView() {
        setContentView(R.layout.activity_main)
        toolbar.title = ""
        setSupportActionBar(toolbar)
        toolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.defaults_status_bar_color))
    }

    override fun initData() {
        toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        initMainPagerContent()

        nav_view.setNavigationItemSelectedListener(this)
        main_toolbar_music.setOnClickListener(this)
        main_toolbar_disco.setOnClickListener(this)
        main_toolbar_friends.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            main_toolbar_disco -> {
                refreshViewState(DISCO_INDEX)
                main_content_view_pager.currentItem = DISCO_INDEX
            }
            main_toolbar_friends -> {
                refreshViewState(FRIENDS_INDEX)
                main_content_view_pager.currentItem = FRIENDS_INDEX
            }
            main_toolbar_music ->{
                refreshViewState(MUSIC_INDEX)
                main_content_view_pager.currentItem = MUSIC_INDEX
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        refreshViewState(position)
    }

    fun refreshViewState(index: Int){
        when(index){
            DISCO_INDEX -> {
                main_toolbar_disco.isSelected = true
                main_toolbar_friends.isSelected = false
                main_toolbar_music.isSelected = false
            }
            MUSIC_INDEX -> {
                main_toolbar_disco.isSelected = false
                main_toolbar_friends.isSelected = false
                main_toolbar_music.isSelected = true
            }
            FRIENDS_INDEX -> {
                main_toolbar_disco.isSelected = false
                main_toolbar_friends.isSelected = true
                main_toolbar_music.isSelected = false
            }
        }
    }

    fun initMainPagerContent(){
        mFragments = listOf<Fragment>(MainMusicFragment(),MainDiscoFragment(),MainFriendsFragment())

        mFragmentPagerAdapter = BaseFragmentPagerAdapter(supportFragmentManager,mFragments, emptyList())
        main_content_view_pager.adapter = mFragmentPagerAdapter
        main_content_view_pager.addOnPageChangeListener(this)
        main_content_view_pager.currentItem = DISCO_INDEX
        refreshViewState(DISCO_INDEX)
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
