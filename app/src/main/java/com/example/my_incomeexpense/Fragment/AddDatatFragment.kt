package com.hkinfo.mybudget_traker.Fragments


import android.R
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.my_incomeexpense.databinding.FragmentAddDataBinding
import com.hkinfo.mybudget_traker.Database.DbHelper
import com.hkinfo.mybudget_traker.Models.TransModel


class AddDatatFragment : Fragment() {


    lateinit var binding: FragmentAddDataBinding

    lateinit var DbHelper : DbHelper
    var isexpense=0
    lateinit var transModel: TransModel
    var year = 0
    var month = 0
    var date = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddDataBinding.inflate(layoutInflater)

        DbHelper = DbHelper(context)

        initview()

        return binding.root
    }

    private fun initview() {

        val spinner = binding.edtCategory

        // Example data for Spinner
        val categories = arrayOf("Category 1", "Category 2", "Category 3")

        // Create ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, categories)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        binding.cardincome.setOnClickListener {
            isexpense=0
            binding.cardincome.setCardBackgroundColor(Color.parseColor("#536CC8"))
            binding.cardexpense.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        binding.cardincome.setOnClickListener {
            isexpense=0
            binding.cardexpense.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.cardincome.setCardBackgroundColor(Color.parseColor("#536CC8"))
            binding.txtAddIncome.text = "Add Income"
        }
        binding.cardexpense.setOnClickListener {
            isexpense=1
            binding.cardexpense.setCardBackgroundColor(Color.parseColor("#DD4545"))
            binding.cardincome.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            binding.txtAddIncome.text = "Add Expense"
        }

        DbHelper = DbHelper(context)
        var list = DbHelper.getTransaction()

        var income = 0
        var expence = 0
        for (trans in list) {
            if (trans.isexpense == 0) {
                income += trans.amt
            } else {
                expence += trans.amt
            }
        }

        binding.AddIncome.setOnClickListener {
            var amt = binding.edtAmt.text.toString().toInt()
            var title = binding.edtTitle.text.toString()
            var category = binding.edtCategory.selectedItem.toString()
            var notes = binding.edtNotes.text.toString()

            if (title.isEmpty() || category.isEmpty() || notes.isEmpty() || amt.toString().isEmpty()) {
                Toast.makeText(context, "Please enter data", Toast.LENGTH_SHORT).show()
            } else {
                var model = TransModel(
                    0, amt, title, category, notes, isexpense, date.toString(), month.toString(), year.toString()
                )
                DbHelper.addAmount(model)
                binding.edtAmt.setText("")
                binding.edtTitle.setText("")

                binding.edtNotes.setText("")
            }
        }

    }
}