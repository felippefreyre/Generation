package com.generation.todolist.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DatePickerFragment(
    private val timePickerListener: TimePickerListener): DialogFragment(),
    DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar. YEAR)
        val month = c.get(Calendar. MONTH)
        val day = c.get(Calendar. DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, year, month, day )
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.YEAR, year)

        timePickerListener.onDateSelected(calendar.time.toInstant().atZone(
            ZoneId.systemDefault()).toLocalDate())

    }
}

interface TimePickerListener{
    fun onDateSelected(date: LocalDate)
}