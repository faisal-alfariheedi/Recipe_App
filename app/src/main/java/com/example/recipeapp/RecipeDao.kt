package com.example.recipeapp

import androidx.room.*


@Dao
interface RecipeDao {

    @Query("SELECT * from recipe")
    fun getall():List<recipe.dat>

    @Query("SELECT * from recipe WHERE id=:id")
    fun getreci(id:Int):recipe.dat

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addeditRecipe(r: recipe.dat)

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addall(r:List<recipe.dat>)

    @Delete
    fun deleteRecipe(r: recipe.dat)
}