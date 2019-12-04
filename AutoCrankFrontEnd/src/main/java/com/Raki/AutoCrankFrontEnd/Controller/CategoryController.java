package com.Raki.AutoCrankFrontEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raki.AutoCrankBackEnd.Dao.CategoryDao;
import com.raki.AutoCrankBackEnd.Model.Category;

public class CategoryController {
@Autowired
Category category; // creating object of Category //MOdelClass

@Autowired
CategoryDao categoryDao;

@RequestMapping("/Category")
public ModelAndView Category() {
ModelAndView mv = new ModelAndView("Category");
List<Category> catlist = categoryDao.list();
mv.addObject("category", new Category());
mv.addObject("categories", catlist);
return mv;
}

@RequestMapping("/addCategory")
public ModelAndView addcat(@ModelAttribute("category") Category category) {
ModelAndView mv = new ModelAndView("redirect:/Category");
if (categoryDao.saveorupdateCategory(category) == true) {
mv.addObject("msg1", "category added Successfully");
} else {
mv.addObject("msg1", "Category Not Added");
}
return mv;
}

@RequestMapping("/editCategory/{catId}") // catId From The Model Class Son it has to be same
public ModelAndView editcat(@PathVariable("catId") String catId) {
ModelAndView mv = new ModelAndView("Category"); // Category must be same as jsp pAGE
category = categoryDao.getCategory(catId);
mv.addObject("category", category);
List<Category> catlist = categoryDao.list();
mv.addObject("categories", catlist);
return mv;

}
}
