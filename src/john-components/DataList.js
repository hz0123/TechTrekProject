const DataList = (props) => {

    return (
        <div className="mt-2">
        {/* Display the article details if article is not None */} 
        {props.data && props.data.map(datum =>{
            return (
                <li key={datum.projectId}>
                  <p>{datum.name}</p>
                  <p>{datum.amount}</p>
                  <p>{datum.updatedAt}</p>
                </li>
              // <div key= {article.id}>
              //   <h2 className="text-primary"> { article.title} </h2>
              //   <p> { article.body } </p>
              //   <p> { article.date } </p>
              //   <hr/>
              // </div>
            )

            })}
        </div>
        )
}

export default DataList;
