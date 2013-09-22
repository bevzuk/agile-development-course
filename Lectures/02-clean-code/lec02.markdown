# Clean Code

Evgeny Sorokin (Intel), Kirill Kornyakov (Itseez)

Сентябрь 2013

# Содержание

  * Почему?
  * Ключевые понятия
  * Чистый код
    - наименование
    - функции/методы
    - коментарии
    - форматирование
    - юнит тесты
  * Заключение

# Почему?

  "Почему? Наши клиенты не смотрят на исходном коде. Почему мы должны держать его в чистоте? ... "

  Генеральный директор компании по разработке программного обеспечения,
  Нижний Новгород, Август 2010

# Качество кода

![](./images/quality.jpg)

# Ключевые понятия

  Код должен быть простым и понятным с первого взгляда! 

* Дублирование
* Шум
* Принцип единой ответсвтенности(ортогональность)
* Уровни абстракции 
* Единообразие

# Основные принципы

* DRY: Don't repeat yourself
* KISS: keep it simple, stupid
* Say what you mean, simply and directly.
* Write clearly - don't be too cleaver.
* Write clearly - don't sacrifice clarity for "efficiency".

# Наименование 

# Наименование типов

  * public class IncompleteOrder {}
  * public class incompleteOrder {}
  * public int currentPosition = -1;
  * public const int NUMBEROFCONTEXTS = 10;
  * private int collectionsize;
  * private string m_strName;
  * private byte _array;

# Абривиатуры

  * int fstIvPos;
  * int firstValidInvoicePosition;
  * private IConnection ODBCConnection;
  * private string DBProvider;
  * private string SqlStatement;
  * string deliveryNoteId;
  * string orderId;

# Классы и методы

  * private bool IsBlocked // Can, Is, Has
  * private bool Blocked
  * public PayableOrder
  * FindById(InternalKey id)

# Паттерн "Команда"

``

    var commands = new List<ICommand> {
       new CompareImages(diff4Big),
       new ExcludeFailedContainers(),
       new ReportResults()
    };

    var data = new ExperimentalData();
    foreach (var command in commands) {
       command.Run(data);
    } 

# Насследованные классы

  * public class SpecializedAttribute : Attribute {}
  * public class CustomerCollection : CollectionsBase {}

# Контекст

  * customer.Name
  * customer.CustomerName

# Magin numbers

  * НЕ ИСПОЛЬЗУЙТЕ ИХ !!!

``

    int dailyPay = hourlyRate * 8;
    double milesWalked = feetWalked / 5280;

  * Используйте:
    - WORK_HOURS_PER_DAY
    - FEET_PER_MILE

# Имена

  * Хорошие имена => самодокументируемый код
  * Плохие имена => Вы не понимаете бизнес область вашего приложения


  * void DoStuff();
  * void SpecificMethod1();
  * List\<PECustomerDetailsData\> RetrieveValidateAndConvertCustomerSpecificDataIntoPresentationEntities();

# Функции 

Какова нормальная длина функции?

    { 
      { 
        while (.. ){ 
          if (..){
              }
          for (.. ){ 
              }
             .... (just putting in the control flow here, imagine another few hundred ifs)
          if(..)   {
                if(..)     {
                       if(..)   {
                    ...
                    (another few hundred brackets)
                           }
                      }
             } //endif

  * The endif showed up around line 800)

# Оптимальное количество параметров функции

    int OverlayFlatVideos(int numberOfFlatVideos, 
                          int currentFrameIdx,
                          OverlayAllVideosParams^ previewParams,
                          std::vector<bool>& StreamProcessed,
                          std::vector<acvCapture*>& flatVideoReaders,
                          std::vector<double>& fpsFlatVideos, 
                          bool sharedReflection,
                          std::vector<CvMat*>& reflectionsFlatToDome, 
                          CvSize& fullDomeSize,
                          std::vector<IplImage*>& masks,
                          std::vector<IplImage*>& borderSmoothImage,
                          CvSize& maskSize,
                          IplImage*& imageFullDome,
                          CvMat*& tempRef,
                          double fps,
                          int& numberOfVideoReaders,
                          IplImage*& imageReflected,
                          IplImage*& imageFullDomeCopy,
                          InterpolationMethod inMethod)

# Функции 

    public ComplexNumber Add(ComplexNumber summand){
      var real = this.Real + summand.Real;
      var imaginary = Imaginary + summand.Imaginary;
      return new ComplexNumber(real, imaginary);
    }
    
    public void Add(OrderItem item){
      items.Add(item);
    }

# Функции 

``

    public List<Document> GetDocuments(Customer customer);
    public List<Customer> FetchCustomers();
    public List<Order> RetrieveOrders();
    public List<CustomerData> LoadDetails(Customer customer);

# Флаги - как параметры

``

    public FileStream Open(string path, bool readOnly) {
    //...
    }

# Выходные параметры

``

    public static
    void GetSupportDocFilePath(out string supportDocFilePath) {
        supportDocFilePath = new ConfigurationHelper().SupportFilePath;
    }
    
    public static string GetSupportDocFilePath() {
        return new ConfigurationHelper().SupportFilePath;
    }

# Условия 

``

    if (splitParameters->projectorVideos == nullptr ||
    System::String::IsNullOrEmpty(splitParameters->splitSettings) ||
    splitParameters->projectorWidth <= 0 ||
    splitParameters->projectorHeight <= 0) {}

    if (timer.HasExpired() && !timer.IsRecurrent()) {}
    if (ShouldBeDeleted(timer)) {}

    if(isValid == false) {}
    if(!canEditPrice) {}

# Избегайте коды ошибок

``

    public void SendShutDown() {
        var handle = GetHandle(device);
        if (handle != DeviceHandle.INVALID) {
            ...
        }
        else {
            Logger.Log("Invalid handle for: " +
            device.ToSting());
        }
    }

# Только одна операция !!!

``

    public void SendShutDown() {
        try {
            TryToShutDown();
        }
        catch (DeviceShutDownError e) {
            logger.Log(e);
        }
    }
    private void TryToShutDown() {
        var handle = GetHandle(device);
        ...
    }

# Мертвый код

#
"Functions should do one thing. They
should do it well. They should do it
only."
Robert Martin

# Комментарии 

``

    // When I wrote this, only God and I understood what I was doing
    // Now, God only knows
    ...

# Комментарии

Они полезны?

  * Неактуальная информация
  * Устаревшие комментарий
  * Избыточный комментарий
  * Плохой комментарий
  * Закоментированный код
  * Дезинформация

# Неактуальная информация, Большой header

``

    /*---------------------------------------------------------------
    -----------------------
    Created by: NANDA
    Created Date: 01-AUG-2009
    Modified by:
    Procedure Description: Fetches menu items based on the given
    user permission
    Input Parameters: LoginEntry user
    Output Parameters: none
    ----------------------------------------------------------------
    --------------------*/
    public BEMenuList FetchMenuItems(LoginEntity user) {
    ...
    }

# Устаревший комментарий

``

    ...
    // Gets the login user id
    // Gets the CRM details
    FetchCrmDetails();
    ...


# Избыточный комментарий 

``

    // If the server variable is empty , throw the error
    message
    if (loginUserId == null)
    {
    throw new Exception(“No User Id”);
    }

# Плохой комментарий

``

    public void LoadProperties() {
        try
        {
            var propertiesPath = propertiesLocation +
            "/" + PROPERTIES_FILE;
            var propertiesStream = File.Open(propertiesPath);
            loadedProperties.Load(propertiesStream);
        }
        catch (IOException ex) {
            //If file with properties doesn’t exist,
            //default settings are loaded
        }
    }

# Закоментированный код

# Еще хуже

# Дезинформация 

``

    /*Auxiliary method: returns control if this.closed is true.
    Throws exception when timeout is reached*/
    public void WaitForClose(long timeoutMillis) {
        if (!closed) {
            Wait(timeoutMillis);
                if (!closed) {
                    throw new Exception("ResponseSender could not be closed");
                }
        }
    }

# Позволительные комментарии

* // format matched kk:mm:ss EEE, MMM dd, yyyy

``

    Pattern timeMatcher = Pattern.Compile("\\d*:\\d*:\\d* \\w*, \\w* \\d*, \\d*");

* // для разработчика

``

    // TODO
    // FIXME


* API (doxygen)

#
"Don’t comment bad code — rewrite it!"
B. Kernighan, P. Plauger
The Elements of Programming Style


# Контрольные вопросы

  1. ...

# Спасибо за внимание!
  * Вопросы?
