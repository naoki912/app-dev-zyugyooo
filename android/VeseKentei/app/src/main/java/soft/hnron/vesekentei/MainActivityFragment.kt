package soft.hnron.vesekentei

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MainActivityFragment : Fragment() {

    private var mListener: MainActivityFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val startButton = view?.findViewById<Button>(R.id.fragment_main__button__start)

        startButton?.setOnClickListener {
            mListener?.onStartButtonClick()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MainActivityFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement MainActivityFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface MainActivityFragmentListener {
        fun onStartButtonClick()
    }

    companion object {
        fun newInstance(): MainActivityFragment = MainActivityFragment()
    }
}
