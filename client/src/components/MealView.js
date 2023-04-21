import {
  Card,
  CardBody,
  CardTitle,
  Col,
  ListGroup,
  ListGroupItem,
} from "reactstrap";

export const MealView = (props) => {
  return (
    <Col>
      <Card body>
        <CardTitle tag="h6">{`${
          props.meal.servingQty
        } servings of ${props.meal.type.toLowerCase()}`}</CardTitle>
        <CardBody>
          <ListGroup>
            {props.meal.foodList.map((foodItem,index) => (
              <ListGroupItem key={`${foodItem}-${index}`}>{`${
                foodItem.servingSize
              } ${foodItem.unitOfMeasure.toLowerCase()} of ${
                foodItem.name
              }`}</ListGroupItem>
            ))}
          </ListGroup>
        </CardBody>
      </Card>
    </Col>
  );
};
