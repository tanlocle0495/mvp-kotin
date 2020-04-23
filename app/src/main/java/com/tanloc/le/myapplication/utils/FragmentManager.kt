package com.tanloc.le.myapplication.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.tanloc.le.myapplication.R


/// disable fragment
internal fun FragmentManager.removeFragment(
    tag: String,
    slideIn: Int = com.tanloc.le.myapplication.R.anim.slide_left,
    slideOut: Int = com.tanloc.le.myapplication.R.anim.slide_right
) {
    this.findFragmentByTag(tag)?.let {
        this.beginTransaction()
        .disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .remove(it)
        .commitNow()
    }
}


//add fragment
internal fun FragmentManager.addFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String,
    slideIn: Int = com.tanloc.le.myapplication.R.anim.slide_left,
    slideOut: Int = com.tanloc.le.myapplication.R.anim.slide_right
) {
    this.beginTransaction().disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .add(containerViewId, fragment, tag)
        .commit()
}
