###Dagger2的使用###

**官方Demo：**

[github的Demo](https://github.com/google/dagger/tree/master/examples/simple/src/main/java/coffee)

**参考文档：**

[官方API](https://google.github.io/dagger/)

[简书推荐](http://www.jianshu.com/p/39d1df6c877d)

####1. 添加依赖：####
	   //dagger2
	   compile 'com.google.dagger:dagger:2.12'
	   annotationProcessor 'com.google.dagger:dagger-compiler:2.12'
	   compile 'com.google.dagger:dagger-android:2.12'
	   compile 'com.google.dagger:dagger-android-support:2.12' // if you use the support libraries
	   annotationProcessor 'com.google.dagger:dagger-android-processor:2.12'

####2. 了解基本的注解方式：####
    @Inject 带有此注解的属性或构造方法将参与到依赖注入中，Dagger2会实例化有此注解的类
    @Module 带有此注解的类，用来提供依赖，里面定义一些用@Provides注解的以provide开头的方法，这些方法就是所提供的依赖，Dagger2会在该类中寻找实例化某个类所需要的依赖。
    @Component 用来将@Inject和@Module联系起来的桥梁，从@Module中获取依赖并将依赖注入给@Inject

####3. 基本使用方式：####
**1. 创建Module：**

创建一个类，在类上方用@Module注解，表明此类是一个提供注解依赖的类，里面定义一些用@Provides注解的以provide开头的方法，用于为我们提供各种实例化对象。
例如：

	   @Module
	   public class DripCoffeeModule {
	       @Provides
	       static Heater provideHeater() {
	           return new ElectricHeater();
	       }
	   
	       @Provides
	       static Pump providePump() {
	           return new Thermosiphon();
	       }
	   }
	   
**2. 创建Component：**

创建一个Component接口，主要为了提供一个桥梁，连接Module和Inject，也是达到一个初始化的作用。
Component接口主要是在使用注解前进行初始化，一般是在Application中进行初始化。例如：

        @Singleton
        @Component(modules = {
                DripCoffeeModule.class,
                AndroidInjectionModule.class,
                ActivityBuildersModule.class
        })
        public interface CoffeeShop {
            @Component.Builder
            interface Builder {
                @BindsInstance
                Builder application(DaggerApplication application);
                CoffeeShop build();
            }
            void inject(DaggerApplication application);
        }

1. @Singleton 单例化
2. @Component指明提供依赖的Modules

**3. 在Application中进行初始化：**

首先，Dagger2利用注解生成代码，先构建项目：`build——>Make Project`,构建好之后，在`app->build->generated->source->apt->dev`中可查看到生成的代码。
根据@Component注解的接口，会生成一个Component的实现类：DaggerXXXComponent，例如Component的接口叫CoffeeShop,生成的实现类是DaggerCoffeeShop。
利用生成的接口的实现在Application中进行初始化：
        
        @Override
            public void onCreate() {
                super.onCreate();
                DaggerCoffeeShop.builder().application(this).build().inject(this);
            }
            
**4. Inject的使用：**

已经完成了初始化以及类的实例化（Module里面的provide），接下来可以使用@Inject注解，创建并实例化一个类(Dagger会自动帮助找到相应的实例化)。
一般Android中在Activity或Fragment中使用。

1. AndroidInjectionModule.class：Android中使用，系统Api提供
2. ActivityBuildersModule.class：Android的Activity中使用，自己创建

例如我们要在Activity中使用@Inject进行初始化，那么，需要在@Component中指明ActivityBuildersModule.class，而这个ActivityBuildersModule是自己创建的！！

        @Module
        public abstract class ActivityBuildersModule {
        
            @ContributesAndroidInjector
            abstract DaggerActivity contributeDaggerActivity();
        
            @ContributesAndroidInjector
            abstract MainActivity contributeMainActivity();
        
        }
        
在Activity或Fragment中使用，首先，Application实现HasActivityInjector或HasFragmentInjector，例如：

        @Inject
        DispatchingAndroidInjector<Fragment> fragmentInjector;
        @Inject
        DispatchingAndroidInjector<Activity> activityInjector;
        
        @Override
        public AndroidInjector<Activity> activityInjector() {
            return activityInjector;
        }
    
        @Override
        public AndroidInjector<Fragment> fragmentInjector() {
            return fragmentInjector;
        }
            
然后要在Activity或Fragment中调用AndroidInject.inject()方法。例如：

        // 在 activity或fragment等中使用注解，需要在application实现HasActivityInjector等相应接口,并且调用该方法
        AndroidInjection.inject(this);

最后就可以使用@Inject注解进行创建对象了：
        
        @Inject
        CoffeeMaker coffeeMaker;
        
        coffeeMaker.brew();
完美Over！

di_Dagger2结合RxJava2＋MVP＋Retrofit。