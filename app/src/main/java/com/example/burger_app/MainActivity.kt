package com.example.burger_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.burger_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BurgerAdapter.FoodClickListener,
    TypeAdapter.PlusClickListener {
    lateinit var binding: ActivityMainBinding

    private var adapter: BurgerAdapter? = null
    private var adapter2: TypeAdapter? = null

    private var category: RecyclerView? = null
    private var category2: RecyclerView? = null

    var burgerList = ArrayList<BurgerType>()
    var filterburlist = ArrayList<BurgerType>()
    var plantList = ArrayList<Burger>()
    var list: ArrayList<BurgerType> = ArrayList()
    var burger = Burger()

    var searcView: SearchView? = null

    var rezult: Int = 0
    var korzina: Int = 1
    var quantity: TextView? = null
    var totalSum: TextView? = null
    var ss: Int  = 0

    var imAge = R.drawable.add_circle
    var imageView = R.drawable.burger
    var imageView1 = R.drawable.bur1
    var imageView2 = R.drawable.bur
    var imageView3 = R.drawable.des
    var imageView4 = R.drawable.des2
    var imageView5 = R.drawable.des3
    var imageView6 = R.drawable.hot
    var imageView7 = R.drawable.hot2
    var imageView8 = R.drawable.hot3
    var imageView9 = R.drawable.sid1
    var imageView10 = R.drawable.sid2
    var imageView11 = R.drawable.sid3

    var imageView12 = R.drawable.pizz1
    var imageView13 = R.drawable.piz2
    var imageView14 = R.drawable.piz3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalSum = findViewById(R.id.textView4)
        quantity = findViewById(R.id.text1)
        binding = ActivityMainBinding.inflate(layoutInflater)
        category = findViewById(R.id.recid)
        searcView = findViewById(R.id.searchField)
        totalSum?.text = ss.toString()



        category2 = findViewById(R.id.recid2)
        burger.imageId = R.drawable.text
        plantList.add(Burger(burger.imageId, "All products", 0))
        plantList.add(Burger(burger.imageId, "Burgers", 1))
        plantList.add(Burger(burger.imageId, "Hot dogs", 2))
        plantList.add(Burger(burger.imageId, "Sides", 3))
        plantList.add(Burger(burger.imageId, "Deserts", 4))
        plantList.add(Burger(burger.imageId, "Pizzas", 5))

        setCategoryRecycle(plantList)/////*/*/*/*/*вернхний ресайкл
        // //*/*/*/*/*//*
//        burgerList.add(BurgerType(imageView, "вкусный гамбургер", "Мега Бургер", 12, 0,imAge))
//        burgerList.add(BurgerType(imageView1, "ГаМбУрГеР", "Ошский Бургер", 24, 0,imAge))
//        burgerList.add(BurgerType(imageView2, "Hamburg", "Араванский", 33, 0,imAge))
//        burgerList.add(BurgerType(imageView3, "под пластом жесткой хрустающей карамели спрятан приятный сливочный крем", "Медовик", 45, 0,imAge))
//        burgerList.add(BurgerType(imageView4, "весьма вкусные жареные мини-пирожные, промоченные в прохладном сахарном сиропе", "Наполеон", 48, 0,imAge))
//        burgerList.add(BurgerType(imageView5, "производится из толченого в пасту липкого риса", "Крем-брюле", 37, 0,imAge))
//        burgerList.add(BurgerType(imageView6, "Оригинальный хот-дог Buffalo Wing Dog с рубленными куриными крыльями", "BUFFALO WING DOG", 345, 0,imAge))
//        burgerList.add(BurgerType(imageView7, "Хот-дог с мясным соусом и колбасой чоризо. Для вегетарианцев заменим сосиску морковью в су-виде", "CHORIZO BBQ DOG", 217, 0,imAge))
//        burgerList.add(BurgerType(imageView8, "с пастой тортильони, сыром Чеддер, трюфельным маслом и чипсами из бекона", "MAC&CHEESE DOG", 698, 0,imAge))
//        burgerList.add(BurgerType(imageView9, "Подобный соус хорошо подойдет к ребрышкам.", "Бурбон-барбекю соус", 854, 0,imAge))
//        burgerList.add(BurgerType(imageView10, "200 г томатного кетчупа, 2 ст. л. растительного масла, 2 зубчика чеснока (измельчить), зелень петрушки, соль и перец.", "Соус «Казанский»", 159, 0,imAge))
//        burgerList.add(BurgerType(imageView11, "400 г отварных шампиньонов (мелко нарезать), 4 ст. л. тертого хрена, 100 г майонеза, 100 г сметаны, соль, перец.", "Соус «Грибной»", 362, 0,imAge))
//        burgerList.add(BurgerType(imageView12, "Прекрасный вариант для любителей разнообразия и оригинального оформления блюд.", "Маргарита", 74, 0,imAge))
//        burgerList.add(BurgerType(imageView13, "Кроме него в состав пиццы входит сливочный соус, ветчина, красный лук и сыр моцарелла.", " Пицца с морепродуктами", 203, 0,imAge))
//        burgerList.add(BurgerType(imageView14, " Настоящая находка для любителей благородных сортов сыра. ", "Четыре сыра", 852, 0, imAge))

        ////*/*/*/*/*//*
        burgerList.add(BurgerType(imageView, "вкусный гамбургер", "Мега Бургер", 12, 1,imAge))
        burgerList.add(BurgerType(imageView1, "ГаМбУрГеР", "Ошский Бургер", 24, 1,imAge))
        burgerList.add(BurgerType(imageView2, "Hamburg", "Араванский", 33, 1,imAge))
        ///*/*/*//*/*/*/*//*/
        burgerList.add(BurgerType(imageView3, "под пластом жесткой хрустающей карамели спрятан приятный сливочный крем", "Медовик", 45, 4,imAge))
        burgerList.add(BurgerType(imageView4, "весьма вкусные жареные мини-пирожные, промоченные в прохладном сахарном сиропе", "Наполеон", 48, 4,imAge))
        burgerList.add(BurgerType(imageView5, "производится из толченого в пасту липкого риса", "Крем-брюле", 37, 4,imAge))
        ////*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/
        burgerList.add(BurgerType(imageView6, "Оригинальный хот-дог Buffalo Wing Dog с рубленными куриными крыльями", "BUFFALO WING DOG", 345, 2,imAge))
        burgerList.add(BurgerType(imageView7, "Хот-дог с мясным соусом и колбасой чоризо. Для вегетарианцев заменим сосиску морковью в су-виде", "CHORIZO BBQ DOG", 217, 2,imAge))
        burgerList.add(BurgerType(imageView8, "с пастой тортильони, сыром Чеддер, трюфельным маслом и чипсами из бекона", "MAC&CHEESE DOG", 698, 2,imAge))
        ////*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/
        burgerList.add(BurgerType(imageView9, "Подобный соус хорошо подойдет к ребрышкам.", "Бурбон-барбекю соус", 854, 3,imAge))
        burgerList.add(BurgerType(imageView10, "200 г томатного кетчупа, 2 ст. л. растительного масла, 2 зубчика чеснока (измельчить), зелень петрушки, соль и перец.", "Соус «Казанский»", 159, 3,imAge))
        burgerList.add(BurgerType(imageView11, "400 г отварных шампиньонов (мелко нарезать), 4 ст. л. тертого хрена, 100 г майонеза, 100 г сметаны, соль, перец.", "Соус «Грибной»", 362, 3,imAge))
////*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/
        burgerList.add(BurgerType(imageView12, "Прекрасный вариант для любителей разнообразия и оригинального оформления блюд.", "Маргарита", 74, 5,imAge))
        burgerList.add(BurgerType(imageView13, "Кроме него в состав пиццы входит сливочный соус, ветчина, красный лук и сыр моцарелла.", " Пицца с морепродуктами", 203, 5,imAge))
        burgerList.add(BurgerType(imageView14, " Настоящая находка для любителей благородных сортов сыра. ", "Четыре сыра", 852, 5, imAge))

        filterburlist.addAll(burgerList)
//        filterburlist.clear()
        setCategoryRecycle22(filterburlist)


        searcView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterburlist.clear()
                val searchText = newText!!.lowercase()
                if (searchText.isNotEmpty()){
                    for (o in burgerList){
                        if (o.name.lowercase().contains(searchText))
                            filterburlist.add(o)
                    }
                    adapter2?.notifyDataSetChanged()
                }
                else{
                    filterburlist.clear()
                    filterburlist.addAll(filterburlist)
                    adapter2?.notifyDataSetChanged()
                }
                return false

            }

        })

    }

    override fun onItemClick(position: Int) {
        filterburlist.clear()
        if (position == 0){
            for (o in burgerList){
                filterburlist.add(o)
                setCategoryRecycle22(filterburlist)
                adapter2?.notifyDataSetChanged()
            }
        }else{
            filterburlist.clear()
            for (o in burgerList) {
                if (o.cateogry == position) {
//                    if (plantList[position].imageId ==  R.drawable.peresvet){
//                        plantList[position].imageId = R.drawable.peresvet
//                    }else{
//                        plantList[position].imageId = R.drawable.text
//                    }
//                    plantList[position].imageId = R.drawable.peresvet
                    filterburlist.add(o)
//                setCategoryRecycle22(list)
                    setCategoryRecycle22(filterburlist)
                    adapter2?.notifyDataSetChanged()

                }
            }
        }

    }
    override fun fonItemClick(position: Int) {
        if (filterburlist.get(position).isSelected == false){
            filterburlist[position].plus = R.drawable.add_circle2
            filterburlist.get(position).isSelected = true
            ss += filterburlist[position].cena
            rezult += korzina
            quantity?.text = rezult.toString()
            totalSum?.text = ss.toString()
            adapter2?.notifyDataSetChanged()


        }else if(filterburlist.get(position).isSelected == true){
            filterburlist[position].plus = R.drawable.add_circle
            filterburlist.get(position).isSelected = false
            ss -= filterburlist[position].cena
            totalSum?.text = ss.toString()
            rezult -= korzina
            quantity?.text = rezult.toString()
            adapter2?.notifyDataSetChanged()
        }
        totalSum?.text = ss.toString()


    }
    private fun setCategoryRecycle22(plantListttt: ArrayList<BurgerType>) {
        adapter2 = TypeAdapter(plantListttt, this)
        category2?.layoutManager = LinearLayoutManager(this)

        category2?.setHasFixedSize(true)
        category2?.adapter = adapter2
        adapter2?.notifyDataSetChanged()

    }

    private fun setCategoryRecycle(plantList: ArrayList<Burger>) {
        adapter = BurgerAdapter(plantList, this, this)
        category?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)


        category?.setHasFixedSize(true)
        category?.adapter = adapter

    }





}



