package com.example.recyclerviewhelloworld

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Our RV adapter
//
// The first line needs a bit of explanation from both Android and Kotlin perspectives... -fgreco
//

class FrankRVAdapter(private val frankData: ArrayList<String>) :    // Pass your data (and datatype) to your Adapter's constructor
    RecyclerView.Adapter<FrankRVAdapter.FrankHolder>() {            // Your adapter subclasses RecyclerView.Adapter.
                                                                    // You have to tell this superclass what view holder datatype you are using.
                                                                    // And you have to specify the primary constructor used to initialize the superclass
                                                                    // Btw, frankData holds my data.  I decided to use an ArrayList (but I could have used any other data structure)

    var numVis: Int = 0         // just to show how many times the onCreateViewHolder() is called

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrankRVAdapter.FrankHolder {
        var context = parent.getContext();
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_listitem, parent, false)
        Log.i("Frank", "onCreateViewHolder() called... " + numVis++)
        return FrankHolder(view)
    }

    override fun onBindViewHolder(holder: FrankHolder, position: Int) {

        holder.textView.text = frankData.get(position).toString()
        Log.i("Frank", "onBindViewHolder() called -------- " + numVis)
    }

    override fun getItemCount(): Int {
        return frankData.size
    }

    /*
     FrankHolder - my view holder.  It subclasses RecyclerView.ViewHolder and indicates the primary constructor to initialize that superclass
     *
     * Since this is a simple hello world, I'm just using a String in each list item of the RV
     */
    class FrankHolder(myView: View) : RecyclerView.ViewHolder(myView) {
        val textView : TextView = myView.findViewById(R.id.textView)
    }
}
