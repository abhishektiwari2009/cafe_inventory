What did you predict for Warmup.java, and what did it actually print? Explain the lines that surprised you.

> > predicted
> > 7 5.0000 130
> > Two
> > Three

What is the difference between the static variable totalProducts and the instance variable name?

> > static variable totalProducts maintains one copy for all the objects. its a class level attribute which gets initialized while class loads. doesnt needs objects to be instantiated.
> > while instance variable gets in to role on runtime and its per instance/objects created. reserves memory per objects. needs objects to be created as its object level entity.

What does the copy constructor do, and why does changing p2.name not change p1.name?

> > because we are copying using this.name and this is current context object.

Why does Java force you to write (int) average when converting a double to an int, and what happens to the decimal part?

> > its called auto type casting, where java ommits the decimal part and coverts it to Integer.

