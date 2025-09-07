package com.mobileappdevelopment.sqlliteproject.View

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mobileappdevelopment.sqlliteproject.Database.UserDatabaseHelper
import com.mobileappdevelopment.sqlliteproject.Model.User
import com.mobileappdevelopment.sqlliteproject.R
import com.mobileappdevelopment.sqlliteproject.Repository.UserRepository
import com.mobileappdevelopment.sqlliteproject.ViewModel.UserViewModel
import com.mobileappdevelopment.sqlliteproject.ViewModel.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etRole: EditText
    private lateinit var btnAdd: Button
    private lateinit var tableLayout: TableLayout

    private val viewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository(UserDatabaseHelper(this)))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etRole = findViewById(R.id.etRole)
        btnAdd = findViewById(R.id.btnAdd)
        tableLayout = findViewById(R.id.tableLayout)

        btnAdd.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val role = etRole.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && role.isNotEmpty()) {
                viewModel.insertUser(User(username = username, password = password, role = role))
                etUsername.text.clear()
                etPassword.text.clear()
                etRole.text.clear()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.users.observe(this) { users ->
            showTable(users)
        }

        viewModel.loadUsers()
    }

    private fun showTable(users: List<User>) {
        tableLayout.removeAllViews()

        // Table Header
        val headerRow = TableRow(this)
        headerRow.addView(makeTextView("ID"))
        headerRow.addView(makeTextView("Username"))
        headerRow.addView(makeTextView("Password"))
        headerRow.addView(makeTextView("Role"))
        headerRow.addView(makeTextView("Actions"))
        tableLayout.addView(headerRow)

        // Table Rows
        for (user in users) {
            val row = TableRow(this)

            row.addView(makeTextView(user.id.toString()))
            row.addView(makeTextView(user.username))
            row.addView(makeTextView(user.password))
            row.addView(makeTextView(user.role))

            val actionLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
            }

            // Update Button
            val btnUpdate = Button(this).apply {
                text = "✏️"
                setOnClickListener { showUpdateDialog(user) }
            }

            // Delete Button
            val btnDelete = Button(this).apply {
                text = "❌"
                setOnClickListener { showDeleteDialog(user) }
            }

            actionLayout.addView(btnUpdate)
            actionLayout.addView(btnDelete)
            row.addView(actionLayout)

            tableLayout.addView(row)
        }
    }

    private fun showUpdateDialog(user: User) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_update_user, null)
        val etUsername = dialogView.findViewById<EditText>(R.id.etUpdateUsername)
        val etPassword = dialogView.findViewById<EditText>(R.id.etUpdatePassword)
        val etRole = dialogView.findViewById<EditText>(R.id.etUpdateRole)

        etUsername.setText(user.username)
        etPassword.setText(user.password)
        etRole.setText(user.role)

        AlertDialog.Builder(this)
            .setTitle("Update User")
            .setView(dialogView)
            .setPositiveButton("Update") { _, _ ->
                val updatedUser = User(
                    id = user.id,
                    username = etUsername.text.toString(),
                    password = etPassword.text.toString(),
                    role = etRole.text.toString()
                )
                viewModel.updateUser(updatedUser)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showDeleteDialog(user: User) {
        AlertDialog.Builder(this)
            .setTitle("Delete User")
            .setMessage("Are you sure you want to delete ${user.username}?")
            .setPositiveButton("Yes") { _, _ -> viewModel.deleteUser(user.id) }
            .setNegativeButton("No", null)
            .show()
    }

    private fun makeTextView(text: String): TextView {
        return TextView(this).apply {
            this.text = text
            setPadding(16, 8, 16, 8)
        }
    }
}