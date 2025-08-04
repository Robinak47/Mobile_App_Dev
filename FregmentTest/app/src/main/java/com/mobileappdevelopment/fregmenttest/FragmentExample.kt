package com.mobileappdevelopment.fregmenttest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentExample: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        Log.i("Message","on CreateView")
        return inflater.inflate(R.layout.fregment_new,container,false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Message","on Create")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Message","on Attach")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Message","on Start")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Message","on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Message","on Stop")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Message","on Resume")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Message","on Destroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Message","on Destroy View")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Message","on Detach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("Message","on activity Created")
    }

}