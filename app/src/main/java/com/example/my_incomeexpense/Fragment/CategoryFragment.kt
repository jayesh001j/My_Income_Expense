package com.example.my_incomeexpense.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.income_expence.model.CategoryModel
import com.example.my_incomeexpense.Adapters.CategoryAdapter
import com.example.my_incomeexpense.databinding.FragmentCategoryBinding
import com.hkinfo.mybudget_traker.Database.DbHelper

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvCategory: RecyclerView
    private lateinit var btnaddCategory: Button
    private lateinit var edtCategory: EditText
    private var list = arrayListOf<CategoryModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbHelper = DbHelper(requireContext())
//        list = dbHelper.getCategory()
        initBinding()
    }

    private fun initBinding() {
        btnaddCategory = binding.btnAddCategory
        edtCategory = binding.edtCategory
        rvCategory = binding.rvCategory

        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        rvCategory.layoutManager = layoutManager

        btnaddCategory.setOnClickListener {
            val db = DbHelper(requireContext())
            if (edtCategory.text.isEmpty()) {
                edtCategory.error = "Please Enter Category"
            } else {
                db.addCategory(edtCategory.text.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
